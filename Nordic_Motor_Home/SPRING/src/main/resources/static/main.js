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
            $('#brandEdit').val(motorhome.brand);
            $('#modelEdit').val(motorhome.model);
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

        $.get(href, function(rentalcontract, status) {
            $('#idEdit').val(rentalcontract.id);
            $('#customerIdEdit').val(rentalcontract.customerId);
            $('#motorhomeIdEdit').val(rentalcontract.motorhomeId);
            $('#accessoryIdEdit').val(rentalcontract.accessoryId);
            $('#seasonEdit').val(rentalcontract.season);
            $('#fromDateEdit').val(rentalcontract.fromDate);
            $('#toDateEdit').val(rentalcontract.toDate);
            $('#fuelEdit').val(rentalcontract.fuel);
            $('#extraKmEdit').val(rentalcontract.extraKm);
            $('#pickUpLocationEdit').val(rentalcontract.pickUpLocation);
            $('#dropOffLocationEdit').val(rentalcontract.dropOffLocation);
            $('#rentalPriceEdit').val(rentalcontract.rentalPrice);
            $('#postRentalPriceEdit').val(rentalcontract.postRentalPrice);
            $('#totalPriceEdit').val(rentalcontract.totalPrice);
            $('#statusEdit').val(rentalcontract.status);
        });
          
         $.get(href, function(customer, status) {
                $('#idEdit').val(customer.id);
                $('#firstNameEdit').val(customer.firstName);
                $('#lastNameEdit').val(customer.lastName);
                $('#addressEdit').val(customer.address);
                $('#zipCodeCustomerEdit').val(customer.zipCodeCustomer);
                $('#cityEdit').val(customer.city);
                $('#phoneNumberEdit').val(customer.phoneNumber);
                $('#emailEdit').val(customer.email);
                $('#driverSinceDateEdit').val(customer.driverSinceDate);
                $('#driverLicenceNumberEdit').val(customer.driverLicenceNumber);
        });

        $('#editModal').modal();
    });

    $('.viewButton').on('click',function(event){

        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function(rentalcontract, status) {
            $('#idView').val(rentalcontract.id);
            $('#firstNameView').val(rentalcontract.firstName)
            $('#lastNameView').val(rentalcontract.lastName);
            $('#addressView').val(rentalcontract.address);
            $('#seasonView').val(rentalcontract.season);
            $('#fromDateView').val(rentalcontract.fromDate);
            $('#toDateView').val(rentalcontract.toDate);
            // $('#fuelView').val(rentalcontract.fuel);
            // $('#extraKmView').val(rentalcontract.extraKm);
            $('#newPickUpLocationView').val(rentalcontract.newPickUpLocation);
            $('#newDropOffLocationView').val(rentalcontract.newDropOffLocation);
            $('#rentalPriceView').val(rentalcontract.rentalPrice);
            $('#postRentalPriceView').val(rentalcontract.postRentalPrice);
            $('#totalPriceView').val(rentalcontract.totalPrice);
            $('#statusView').val(rentalcontract.status);
        });

        $('#viewModal').modal();
    });
});