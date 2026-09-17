# Order Service

Spring Boot microservice responsible for order lifecycle management.

## Entities
- `Order` -> maps to `orders` table

## Repository Methods
- `findByCustomerEmail` (indexed)
- `findByStatus` (indexed)
