// Kjører koden når dokumentet er ferdig lastet
$(function () {
    console.log("Dokumentet er klart.");

    // Hent alle motorvogner når dokumentet er ferdig lastet
    hentAlle();

    // Legg til klikk-hendelse for registrer-knappen
    $("#registrerBtn").on("click", function (event) {
        console.log("Registrer-knappen er klikket.");

        // Forhindrer standard skjema-innsending
        event.preventDefault();

        // Kall funksjonen for å registrere motorvogn
        regMotorvogn();
    });
});

// Funksjon for å registrere en ny motorvogn
function regMotorvogn() {
    console.log("Inne i regMotorvogn-funksjonen.");
    const reg = {
        personnr: $("#personnr").val(),
        navn: $("#navn").val(),
        adresse: $("#adresse").val(),
        kjennetegn: $("#kjennetegn").val(),
        merke: $("#merke").val(),
        type: $("#type").val()
    };

    // Lagre registreringen ved å sende en POST-forespørsel til serveren
    $.post("/motorvogn/lagre", reg, function () {
        // Hent oppdaterte data etter vellykket lagring
        hentAlle();

        // Tøm inndatafeltene etter vellykket lagring
        $("#personnr").val("");
        $("#navn").val("");
        $("#adresse").val("");
        $("#kjennetegn").val("");
        $("#merke").val("");
        $("#type").val("");
    });
}

// Funksjon for å hente alle motorvogner fra serveren
function hentAlle() {
    console.log("Forsøker å hente data...");
    // Send GET-forespørsel til serveren for å hente alle motorvogner
    $.get("/motorvogn/hentAlle", function (biler) {
        console.log("Data hentet vellykket:", biler);
        // Formater dataene og vis dem på siden
        formaterData(biler);
    }).fail(function (xhr, status, error) {
        console.error("Feil ved henting av data:", status, error);
    });
}

// Funksjon for å formatere og vise dataene på siden
function formaterData(biler) {
    let ut = "<table class='table table-striped'><tr><th>Personnr</th><th>Navn</th><th>Adresse</th>" +
        "<th>Kjennetegn</th><th>Merke</th><th>Type</th></tr>";
    for (const bil of biler) {
        ut += "<tr><td>" + bil.personnr + "</td><td>" + bil.navn + "</td><td>" + bil.adresse + "</td>" +
            "<td>" + bil.kjennetegn + "</td><td>" + bil.merke + "</td><td>" + bil.type + "</td></tr>";
    }
    ut += "</table>";
    // Sett inn den formaterte tabellen i HTML-elementet med id 'bilene'
    $("#bilene").html(ut);
}

// Funksjon for å slette alle registreringer fra serveren
function slettAlle() {
    // Send GET-forespørsel til serveren for å slette alle motorvogner
    $.get("/motorvogn/slettAlle", function (biler) {
        // Hent oppdaterte data etter vellykket sletting
        hentAlle();
    });
}
