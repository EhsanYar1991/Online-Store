$(document).ready(function() {
    // create MultiSelect from select HTML element
    var required = $("#required").kendoMultiSelect().data("kendoMultiSelect");
    var optional = $("#optional").kendoMultiSelect({
        autoClose: false
    }).data("kendoMultiSelect");

    $("#get").click(function() {
        alert("Attendees:\n\nRequired: " + required.value() + "\nOptional: " + optional.value());
    });
});



