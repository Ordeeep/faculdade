const readline = require("readline").createInterface({
    input: process.stdin,
    output: process.stdout,
  });
  
  const mdc = (input) => {
    let [a, b] = input.split(" ");
  
    if (isNaN(a) || isNaN(b)) {
      console.log("Os valores devem ser números positivos!");
      return;
    }
  
    if (a <= 0 || b <= 0) {
      console.log("Os números devem ser positivos!");
      return;
    }
  
    while (b !== 0) {
      let temp = b;
      b = a % b;
      a = temp;
    }
    return console.log(a);
  };
  
  readline.question("Digite dois números inteiros: ", (input) => {
    readline.close();
    mdc(
      input
        .replace(",", "")
        .replace(/\s{2,}/g, " ")
        .trim()
    );
  });
