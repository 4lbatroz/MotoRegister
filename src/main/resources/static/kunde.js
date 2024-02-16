$(function () {
    console.log("Document is ready.");

    // kjøres når dokumentet er ferdig lastet
    hentAlle();

    // Legg til click-event for registrer-knappen
    $("#registrerBtn").on("click", function (event) {
        console.log("Registrer button clicked.");

        // Prevent default form submission
        event.preventDefault();

        regMotorvogn();
    });
});

function regMotorvogn() {
    console.log("Inside regMotorvogn function.");
    const reg = {
        personnr: $("#personnr").val(),
        navn: $("#navn").val(),
        adresse: $("#adresse").val(),
        kjennetegn: $("#kjennetegn").val(),
        merke: $("#merke").val(),
        type: $("#type").val()
    };

    //lagrer registreringen
    $.post("/motorvogn/lagre", reg, function () {
        hentAlle();

        // Clear input fields after successful save
        $("#personnr").val("");
        $("#navn").val("");
        $("#adresse").val("");
        $("#kjennetegn").val("");
        $("#merke").val("");
        $("#type").val("");
    });
}

//henter alle bilene
function hentAlle() {
    console.log("Attempting to fetch data...");
    $.get("/motorvogn/hentAlle", function (biler) {
        console.log("Data fetched successfully:", biler);
        formaterData(biler);
    }).fail(function (xhr, status, error) {
        console.error("Error fetching data:", status, error);
    });
}

//viser hvordan de skal vises på siden
function formaterData(biler) {
    let ut = "<table class='table table-striped'><tr><th>Personnr</th><th>Navn</th><th>Adresse</th>" +
        "<th>Kjennetegn</th><th>Merke</th><th>Type</th></tr>";
    for (const bil of biler) {
        ut += "<tr><td>" + bil.personnr + "</td><td>" + bil.navn + "</td><td>" + bil.adresse + "</td>" +
            "<td>" + bil.kjennetegn + "</td><td>" + bil.merke + "</td><td>" + bil.type + "</td></tr>";
    }
    ut += "</table>";
    $("#bilene").html(ut);
}

//sletter alle registreringer
function slettAlle() {
    $.get("/motorvogn/slettAlle", function (biler) {
        hentAlle();
    });
}
