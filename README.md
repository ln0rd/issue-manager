## Projeto de votos por issue

Projeto que simula uma votação.

### Requisitos
- docker
- docker-compose

### Documentação Postman
```https://documenter.getpostman.com/view/5267825/VUjJs8Fm```

### Como rodar o projeto
```
docker-compose up --build
```

Assim que subir o projeto estará rodando na rota `localhost:8080`

### Como foi pensando o projeto

Nesse projeto você pode criar uma `issue` para poder realizar um voto, a partir de uma `issue` cadastrada
você pode criar uma sessão de votação, com uma sessão de votação criado, enviado na requisição um id de um usuário você pode
realizar um voto podendo ser um sim ou não, um usuário so vai poder votar uma vez por `issue` mas podemos criar uma
nova sessão caso queira votar uma `issue` novamente.

Todas as requisições para a api estão na documentação do postman.
