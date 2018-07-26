function showDateTime() {
  // Créer une variable contenant un string de date et d'heure actuelles
  var date = new Date().toLocaleString();

  // Récupérer l'élément span et ajouter la date dans span.
  document.getElementById("dateTimeText").innerHTML = date;
}

// Appeler la méthode showDateTime quand la page web est chargée
window.onload = showDateTime;
