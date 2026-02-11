const input = require('fs').readFileSync(0, 'utf8').trim().split('\n');

const [N, M] = input[0].split(' ').map(Number);
const graph = Array.from({ length: N + 1 }, () => []);

for (let i = 1; i <= M; i++) {
  const [a, b, c] = input[i].split(' ').map(Number);
  graph[a].push([b, c]);
  graph[b].push([a, c]);
}

const dist = Array(N + 1).fill(Infinity);
dist[1] = 0;

const pq = [[0, 1]];

while (pq.length) {
  pq.sort((a, b) => a[0] - b[0]);
  const [cost, now] = pq.shift();

  if (cost > dist[now]) continue;

  for (const [next, weight] of graph[now]) {
    const newCost = cost + weight;
    if (newCost < dist[next]) {
      dist[next] = newCost;
      pq.push([newCost, next]);
    }
  }
}

console.log(dist[N]);
