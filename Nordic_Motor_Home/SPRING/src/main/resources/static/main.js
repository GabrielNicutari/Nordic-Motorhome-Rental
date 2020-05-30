/**
 *
 */

$('document').ready(function() {

    $('.deleteButton').on('click',function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#deleteModal #delRef').attr('href', href);
        $('#deleteModal').modal();
    });


    $('.editButton').on('click',function(event){

        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function(motorhome, status) {
            $('#idEdit').val(motorhome.id);
            $('#modelIdEdit').val(motorhome.modelId);
            $('#hpEdit').val(motorhome.hp);
            $('#plateEdit').val(motorhome.plate);
            $('#seatNumberEdit').val(motorhome.seatNumber);
            $('#seatsMaterialEdit').val(motorhome.seatsMaterial);
            $('#cruiseControlEdit').val(motorhome.cruiseControl);
            $('#pricePerDayEdit').val(motorhome.pricePerDay);
            $('#availabilityEdit').val(motorhome.availability);
        });

        $.get(href, function(employee, status) {
            $('#idEdit').val(employee.id);
            $('#firstNameEdit').val(employee.firstName);
            $('#lastNameEdit').val(employee.lastName);
            $('#addressEdit').val(employee.address);
            $('#zipCodeEdit').val(employee.zipCodeEmployee);
            $('#cityEdit').val(employee.city);
            $('#phoneNumberEdit').val(employee.phoneNumber);
            $('#emailEdit').val(employee.email);
            $('#cprEdit').val(employee.cpr);
            $('#roleEdit').val(employee.role);
            $('#hoursPerWeekEdit').val(employee.hoursPerWeek);
            $('#wageEdit').val(employee.wage);
        });

        $('#editModal').modal();
    });
});
