const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

let soma = 0;
let quantidade;

const perguntar = (contador) => {
  if (contador <= quantidade) {
    rl.question(`Digite o número ${contador}: `, (numero) => {
      numero = Number(numero);
      if (isNaN(numero)) {
        console.log('Por favor, digite um número válido.');
        perguntar(contador);
      } else {
        soma += numero;
        perguntar(contador + 1);
      }
    });
  } else {
    console.log(`O somatório é ${soma}`);
    rl.close();
  }
};

rl.question('Digite a quantidade de números a serem somados: ', (quant) => {
  quantidade = Number(quant);
  if (isNaN(quantidade) || quantidade < 1) {
    console.log('Por favor, digite uma quantidade válida.');
    rl.close();
  } else {
    perguntar(1);
  }
});