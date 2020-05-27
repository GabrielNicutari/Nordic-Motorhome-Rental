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

            $.get(href, function(customer, status) {
                $('#idEdit').val(customer.id);
                $('#firstNameEdit').val(customer.firstName);
                $('#lastNameEdit').val(customer.lastName);
                $('#addressEdit').val(customer.address);
                $('#phoneNumberEdit').val(customer.phoneNumber);
                $('#emailEdit').val(customer.email);
                $('#driverLicenceNumberEdit').val(customer.driverLicenceNumber);
                $('#driverSinceDateEdit').val(customer.driverSinceDate);
            });

            $('#editModal').modal();
        });
});

