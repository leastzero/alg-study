let example = `
5 150
0 50 10
0 50 20
50 100 10
100 151 10
110 140 90
`
let data = example.trim();
data = data.split('\n');
let [number, totalLen] = data[0].split(' ').map(Number);
data.shift();


let method = [];
data.map((n) => {
    method.push(n.split(' ').map(Number));
});

method.sort((a,b) => {
    return a[1] - b[1];
});

console.log(method);

let saveLen = 0;
method.reduce((acc, cur, idx) => {
    let [start, end, shortcut] = method[idx];
    acc = acc + end;
    saveLen = 
    
}, 0)