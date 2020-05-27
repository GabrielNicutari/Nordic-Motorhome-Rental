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

        $('#editModal').modal();
    });

    $('.viewButton').on('click',function(event){

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

        $.get(href, function(rentalcontract, status) {
            $('#idView').val(rentalcontract.id);
            $('#customerIdView').val(rentalcontract.customerId);
            $('#motorhomeIdView').val(rentalcontract.motorhomeId);
            $('#accessoryIdView').val(rentalcontract.accessoryId);
            $('#seasonView').val(rentalcontract.season);
            $('#fromDateView').val(rentalcontract.fromDate);
            $('#toDateView').val(rentalcontract.toDate);
            $('#fuelView').val(rentalcontract.fuel);
            $('#extraKmView').val(rentalcontract.extraKm);
            $('#pickUpLocationView').val(rentalcontract.pickUpLocation);
            $('#dropOffLocationView').val(rentalcontract.dropOffLocation);
            $('#rentalPriceView').val(rentalcontract.rentalPrice);
            $('#postRentalPriceView').val(rentalcontract.postRentalPrice);
            $('#totalPriceView').val(rentalcontract.totalPrice);
            $('#statusView').val(rentalcontract.status);
        });

        $('#viewModal').modal();
    });

});
