# QN3-AquaSmart-Meter

Smart prepaid water-metering system for Kalangala Infrastructure Services Ltd (KIS).

## Structure

```
src/main/java/com/kis/aquasmart/
├── SmartMeter.java         // Core class: credit balance, valve control
└── Main.java               // Demo with sample transactions

src/test/java/com/kis/aquasmart/
└── SmartMeterTest.java     // JUnit 5 tests
```

## How to Run

```bash
# Run demo
mvn compile
java -cp target/classes com.kis.aquasmart.Main

# Run tests
mvn test
```

## SmartMeter Specs

| Method | Behaviour |
|---|---|
| `loadToken(amount)` | Adds credit, reopens valve if closed, returns new balance |
| `recordConsumption(litres)` | Deducts litres × UGX 50; closes valve if credit exhausted |

### Consumption Rule
- 1 litre = **UGX 50**
- If cost > available credit → balance = 0, valve closes, returns `false`
- If valve is closed → all consumption requests return `false`

## JUnit Tests

1. **`loadToken_reopensClosedValve`** — exhaust credit, verify valve closes, load token, verify valve reopens
2. **`consumptionBeyondCredit_closesValve`** — attempt over-consumption, verify balance = 0 and valve closed

## GitHub

Repository: `QN3-AquaSmart-Meter`
