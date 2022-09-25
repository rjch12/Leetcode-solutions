function test(message) {
  return new Promise((resolve, reject) => {
    setTimeout(() => resolve(message), 1000);
  });
}

const test2 = (message) => {
  return new Promise((resolve, reject) => {
    setTimeout(() => resolve(message), 2000);
  });
};

function Polyfill(promises) {
  let results = [];

  if (promises.length === 0) {
    resolve(results);
  }
  return new Promise((resolve, reject) => {
    promises.forEach((p, idx) => {
      p.then((res) => {
        console.log(res);
        results.push(res);
      }).catch((err) => {
        reject(err);
      });
      if (idx == promises.length) resolve(results);
    });
  });
}

Polyfill([test("hello"), test2("bello")])
  .then((data) => console.log(data));