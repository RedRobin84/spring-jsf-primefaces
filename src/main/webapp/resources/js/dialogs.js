function handleSubmitRequest(xhr, status, args, dialogName, formName) {
    dialog = jQuery('#' + dialogName);
    if (args.validationFailed) {
        dialog.effect("shake", {times : 3}, 100);
    } else {
        clearForm(formName);
        dlgNewUser.hide();
        dlgUserDetail.hide();
        dlgEditUser.hide();
    }
}

function clearForm(formName) {
    jQuery('#' + formName).each(function() {
        this.reset();
    });
}