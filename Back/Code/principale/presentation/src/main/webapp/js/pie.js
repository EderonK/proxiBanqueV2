google.charts.load("current", {packages:["corechart"]});
google.charts.setOnLoadCallback(drawChart);
function drawChart() {
  var data = google.visualization.arrayToDataTable([

    ['Task', 'Virements du mois'],
    ['On un montant entre 0Euros et 2000Euros',     50],
    ['On un montant entre 2000Euros et 7000Euros',      25],
    ['On un montant supérieur a 7000 Euros',  25],

  ]);

  var options = {
    title: 'Les virements du mois',
    is3D: true,
  };

  var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
  chart.draw(data, options);
}
