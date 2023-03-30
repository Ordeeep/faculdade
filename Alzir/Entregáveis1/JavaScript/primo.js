const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

rl.question('Digite um número: ', (numero) => {
  let ehPrimo = true;
  
  if (numero < 2) {
    ehPrimo = false;
  }

  for (let i = 2; i <= Math.sqrt(numero); i++) {
    if (numero % i === 0) {
      ehPrimo = false;
      break;
    }
  }

  if (ehPrimo) {
    console.log(numero + ' é primo.');
  } else {
    console.log(numero + ' não é primo.');
  }

  rl.close();
});