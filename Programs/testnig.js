console.log("start");

const p = new Promise((resolve, reject) => {
    console.log(1);
    resolve(2);
  });

p.then((data) => console.log(data)).catch((err) => console.error(err));

console.log("end");