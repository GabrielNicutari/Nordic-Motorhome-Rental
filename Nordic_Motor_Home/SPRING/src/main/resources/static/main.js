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
            $('#statusView').val(rentalcontract.status);
            $('#fromDateView').val(rentalcontract.fromDate);
            $('#toDateView').val(rentalcontract.toDate);
            $('#seasonView').val(rentalcontract.season);
            $('#newPickUpLocationView').val(rentalcontract.newPickUpLocation);
            $('#newDropOffLocationView').val(rentalcontract.newDropOffLocation);
            // $('#fuelView').val(rentalcontract.fuel);
            // $('#extraKmView').val(rentalcontract.extraKm);

            $('#firstNameView').val(rentalcontract.firstName)
            $('#lastNameView').val(rentalcontract.lastName);
            $('#addressView').val(rentalcontract.address);
            $('#zipCodeCustomerView').val(rentalcontract.zipCodeCustomer);
            $('#cityView').val(rentalcontract.city);
            $('#phoneNumberView').val(rentalcontract.phoneNumber);
            $('#emailView').val(rentalcontract.email);
            $('#driverLicenceNumberView').val(rentalcontract.driverLicenceNumber);
            $('#driverSinceDateView').val(rentalcontract.driverSinceDate);

            $('#brandView').val(rentalcontract.brand);
            $('#modelView').val(rentalcontract.model);
            $('#plateView').val(rentalcontract.plate);
            $('#budgetView').val(rentalcontract.budget);
            $('#sizeView').val(rentalcontract.size);
            $('#fuelTypeView').val(rentalcontract.fuelType);
            $('#cruiseControlView').val(rentalcontract.cruiseControl);
            $('#hpView').val(rentalcontract.hp);
            $('#seatNumberView').val(rentalcontract.seatNumber);
            $('#seatsMaterialView').val(rentalcontract.seatsMaterial);
            $('#pricePerDayView').val(rentalcontract.pricePerDay);

            $('#rentalPriceView').val(rentalcontract.rentalPrice);
            $('#postRentalPriceView').val(rentalcontract.postRentalPrice);
            $('#totalPriceView').val(rentalcontract.totalPrice);

        });

        $('#viewModal').modal();
    });
});