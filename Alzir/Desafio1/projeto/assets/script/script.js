function calcularDias() {
  //Pega os valores direto do input data
  let day = document.getElementById('day').value;
  let month = document.getElementById('month').value;
  let year = document.getElementById('year').value;

  let daysResult = document.getElementById('daysResult')
  let monthsResult = document.getElementById('monthsResult')
  let yearsResult = document.getElementById('yearsResult')
  // Obtendo a data atual
  let currentDate = moment();

  // Criando uma data a partir dos valores fornecidos
  let birthDate = moment(`${year}-${month}-${day}`, 'YYYY-MM-DD');

  // Calculando a diferença em dias, meses e anos
  let diff = moment.duration(currentDate.diff(birthDate));

  let years = diff.years();
  let months = diff.months();
  let days = diff.days();


  //Imprime os resultados na tela
  daysResult.innerHTML = days;
  monthsResult.innerHTML = months;
  yearsResult.innerHTML = years;

  console.log(`Anos: ${years}, Meses: ${months}, Dias: ${days}`);
}