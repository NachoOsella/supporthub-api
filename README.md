# supporthub-api

Backend de soporte evolutivo para seguir el roadmap NestJS por fases.

## Proposito

`supporthub-api` es la aplicacion que se va construyendo durante el roadmap:

- arranca directamente en NestJS
- evoluciona sobre una misma base de codigo
- modela un sistema de tickets de soporte
- prioriza backend, criterios claros y narrativa tecnica defendible

## Que Problema Resuelve

El proyecto representa un sistema de soporte con distintos actores y reglas:

- `customer`
- `agent`
- `admin`

La idea es llegar a una API que permita:

- autenticacion con JWT
- autorizacion por roles
- CRUD principal de tickets
- comentarios o seguimiento del ticket
- cambios de estado
- auditoria basica
- documentacion con Swagger
- pruebas sobre flujos criticos
- despliegue reproducible con Docker

## Roadmap

El desarrollo sigue estas fases:

1. Bases previas
2. Fundamentos de NestJS
3. CRUD, DTOs y validacion
4. Persistencia con PostgreSQL
5. Auth y autorizacion
6. Testing y documentacion
7. Backend avanzado
8. Arquitectura profesional
9. Proyecto final para CV

## Estado Del Repositorio

En este punto el repositorio queda preparado para empezar la implementacion real del backend.

## Criterio De Calidad

La referencia de calidad del proyecto es simple:

- el flujo principal tiene que ser entendible
- la estructura tiene que ser defendible en entrevista
- la documentacion tiene que permitir arrancar el proyecto sin adivinar
- los archivos de entorno, build y despliegue tienen que ser reproducibles

## Estructura Esperada

La base final del proyecto deberia crecer hacia una organizacion parecida a esta:

```text
src/
  auth/
  users/
  tickets/
  comments/
  attachments/
  audit-log/
  notifications/
  prisma/
  common/
```

## Requisitos De Entorno

El roadmap sugiere un backend NestJS con estas piezas tipicas:

- Node.js
- npm
- NestJS
- PostgreSQL
- Prisma
- Swagger
- Docker

## Variables De Entorno

Cuando el proyecto avance, conviene documentar al menos:

- `DATABASE_URL`
- `JWT_SECRET`
- variables de puerto y entorno

## Arranque Local

Cuando existan las dependencias del proyecto, el flujo normal deberia ser:

```bash
npm install
npm run start:dev
```

## Notas

Este repositorio sigue el enfoque pedagógico del roadmap: un solo proyecto evolutivo, sin ruido de migraciones innecesarias y con foco en decisiones técnicas que se puedan explicar.
