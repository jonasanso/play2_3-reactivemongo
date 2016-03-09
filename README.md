# Configure

Just review application.conf and point to your mongoDB

# Run

```
sbt run
```


# Send Json to store
```
curl -H "Content-Type: application/json" -X POST -d '{"username":"xyz","password":"xyz"}' http://localhost:9000/json
```