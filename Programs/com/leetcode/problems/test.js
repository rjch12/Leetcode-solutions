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

Polyfill([test("hello"), test2("bello")]).then((data) => console.log(data));

console.log(a);

function test1(message) {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve(message);
    }, 1000);
  });
}

function test2(message) {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve(message);
    }, 1000);
  });
}

function polyFill(promises) {
  let result = [];
  let len = promises.length;

  return new Promise((resolve, reject) => {
    promises.forEach((p, ind) => {
      p.then((data) => result.push(data)).catch((err) => reject(err));
      if (ind === promises.length) resolve(result);
    });
  });
}

polyFill(test1("hello"), test2("bello"))
  .then((data) => console.log(data))
  .catch((err) => console.log(err));



console.log("start");

function p (message) {
  return new Promise((resolve, reject) => {
    console.log(1);
    resolve(message);
  });
}

p(2);

console.log("end");