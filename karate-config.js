function karateconf() {
  karate.configure('connectTimeout', 5000);
  karate.configure('readTimeout', 5000);
  var config = { baseURL: 'http://localhost:8080' };
  return config;
}