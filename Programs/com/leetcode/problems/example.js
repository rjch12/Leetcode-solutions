const https = require('https')
// let url = "https://docs.aws.amazon.com/lambda/latest/dg/welcome.html"   
let url = "https://docs.aws.amazon.com/lambda/latest/dg/welcome.html"   

async function f () {
  const promise = new Promise(function(resolve, reject) {
    https.get(url, (res) => {
        resolve(res.statusCode)
      }).on('error', (e) => {
        reject(Error(e))
      })
    });
  
  promise.then((data) => console.log(data)).catch((err) => console.log(err));
}

f();

// move = DRR
// portalA = 1,1
// portalB = 2,3
// width = 3
// height = 4