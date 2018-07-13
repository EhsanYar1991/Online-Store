package com.yar.onlinestore.controller.web;


import com.yar.onlinestore.common.bundle.ErrorMessages;
import com.yar.onlinestore.common.bundle.MessageService;
import com.yar.onlinestore.common.exception.AuthorizationExeption;
import com.yar.onlinestore.common.exception.InternalException;
import com.yar.onlinestore.common.exception.UserServiceException;
import com.yar.onlinestore.configs.security.SecurityRole;
import com.yar.onlinestore.service.domain.UserManagement;
import com.yar.onlinestore.service.dto.user.UserDTO;
import com.yar.onlinestore.service.dto.user.UserRoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("HardcodedFileSeparator")
@Controller
@RequestMapping
public class WebController {

    private final UserManagement userManagement;
    private final MessageService messageService;

    @Autowired
    public WebController(UserManagement userManagement, MessageService messageService) {
        this.userManagement = userManagement;
        this.messageService = messageService;
    }

    @GetMapping(value = "/principal")
    @ResponseBody
    public ResponseEntity<?> user(Principal principal) throws AuthorizationExeption {
        if (principal == null) throw new AuthorizationExeption(messageService.getMessage(ErrorMessages.NOT_AUTHORIZED));
        return new ResponseEntity<>(principal, HttpStatus.OK);
    }

    @RequestMapping(value = {"/", "/admin"})
    public String login(Model model, Principal principal) {

        if (principal != null && userIsEnable(principal)) {

            if (hasRole(principal, SecurityRole.ADMIN.getRole())) {
                model.addAttribute("roles", userManagement.getAllRoleDtos());
                model.addAttribute("users", userManagement.getAllUsers());
                return "admin";
            }
            if (hasRole(principal, SecurityRole.MANAGER.getRole())) {
                model.addAttribute("users", userManagement.getAllUserWithRole(SecurityRole.USER.getRole()));
                return "manager";
            }
            if (hasRole(principal, SecurityRole.USER.getRole())) {
                UserDTO userByUserName = userManagement.findUserByUserName(principal.getName());
                model.addAttribute("user", userByUserName);
                return "report";
            }
        }

        return "redirect:login";
    }

    private boolean userIsEnable(Principal principal) {
        return ((User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal()).isEnabled();
    }

    private boolean hasRole(Principal principal, String role) {
        SimpleGrantedAuthority admin = new SimpleGrantedAuthority(role);
        return ((UsernamePasswordAuthenticationToken) principal).getAuthorities().contains(admin);
    }


    @RequestMapping(value = "/addNewRole", method = RequestMethod.POST)
    public String addNewRole(@ModelAttribute UserRoleDTO userRoleDTO) {

        userManagement.addNewRole(userRoleDTO);

        return "redirect:/";
    }


    @RequestMapping(value = "/addNewUser", method = RequestMethod.POST)
    public String addNewUser(@RequestParam(name = "username") String username,
                             @RequestParam(name = "password") String password,
                             @RequestParam(name = "enable") boolean enable,
                             @RequestParam(name = "role") String role) throws InternalException {

        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(username);
        userDTO.setPassword(password);
        userDTO.setEnable(enable);
        UserRoleDTO userRoleDTO = new UserRoleDTO();
        userRoleDTO.setRole(role);
        Set<UserRoleDTO> userRoleDTOS = new HashSet<>();
        userRoleDTOS.add(userRoleDTO);
        userDTO.setRoleSet(userRoleDTOS);

        userManagement.addUser(userDTO, role);

        return "redirect:/";
    }

    /*@RequestMapping(value = "/report", method = RequestMethod.POST)
    public String adminReport(Principal principal,
                              Model model,
                              @RequestParam("userSerialId") Long userSerialId) throws UserServiceException {
        if (hasRole(principal, "ADMIN") || hasRole(principal, "MANAGER")) {
            model.addAttribute("user", userManagement.findUserDtoByUserSerialId(userSerialId));
        }
        return report(principal, model);

    }*/

    @RequestMapping(value = "/report", method = RequestMethod.GET)
    public String report(Principal principal,
                         Model model,
                         @RequestParam("userSerialId") Long userSerialId) throws UserServiceException {
        if (hasRole(principal, SecurityRole.ADMIN.getRole()) || hasRole(principal, SecurityRole.MANAGER.getRole())) {
//            if (userSerialId != null && !userSerialId.equals(0L))
//                model.addAttribute("user", userManagement.findUserDtoByUserSerialId(userSerialId));
        }
        if (hasRole(principal, SecurityRole.USER.getRole())) {
            model.addAttribute("user", userManagement.findUserByUserName(principal.getName()));
        }
//        List<TransactionInfo> transactionInfos = transactionInfoManagement.allTransactionInfoEntitiesByUser(userManagement.findUserByUserSerialId(userSerialId));
//        model.addAttribute("transactions" , transactionInfos);

        return "report";
    }


}
