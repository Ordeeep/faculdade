const fibonacci = (num) => {
    if (num < 2) {
      return num;
    } else {
      return fibonacci(num - 1) + fibonacci(num - 2);
    }
  };
  
  const readline = require("readline").createInterface({
    input: process.stdin,
    output: process.stdout,
  });
  
  readline.question("Digite um número: ", (n) => {
    n = parseInt(n);
    if (n <= 0 || isNaN(n)) {
      console.log("Digite um número inteiro positivo!");
      readline.close();
    } else {
      for (let i = 0; i < n; i++) {
        console.log(fibonacci(i));
      }
      readline.close();
    }
  });