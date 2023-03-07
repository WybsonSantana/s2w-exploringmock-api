# s2w-exploringmock-api

---

![GitHub repo size](https://img.shields.io/github/repo-size/iuricode/README-template?style=for-the-badge)
![GitHub language count](https://img.shields.io/github/languages/count/iuricode/README-template?style=for-the-badge)
![GitHub forks](https://img.shields.io/github/forks/iuricode/README-template?style=for-the-badge)
![Bitbucket open issues](https://img.shields.io/bitbucket/issues/iuricode/README-template?style=for-the-badge)
![Bitbucket open pull requests](https://img.shields.io/bitbucket/pr-raw/iuricode/README-template?style=for-the-badge)

---

## 💻 Sobre o projeto

Projeto criado com intuito de exercitar a construção de uma API e demonstrar aos colegas de estudo como a utilização de mocks pode nos ajudar com a simulação de uma integração com outros microsserviços.

---

## 📂 Collection

[s2w-exploringmock-api-collection](./collection/s2w-exploringmock-api-collection.json)

---

## ⚙ Funcionalidades

A aplicação possui dois endpoints que utilizam o Spring Cloud Open Feign para se integrarem ao Wiremock e retornar as informações solicitadas.   

### 🔘 /message/get

Integra-se a outro microsserviço e recupera os dados de uma mensagem.

#### ⬅ Requisição

~~~yaml
path: /message/get
method: GET
headers:
    authorization: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6InMydy1leHBsb3Jpbmdtb2NrLWFwaSIsImlhdCI6MTUxNjIzOTAyMn0.zkNVNZrzL4pG-iXj3YEYL-vd5yUV0u3HoDy8IFKtGa8 
~~~

#### ➡ Resposta

Status: `200 Ok`
<br>
Body:
~~~json
{
  "message": "Hello, Wiremock!"
}
~~~

### 🔘 /customer/{document-number}/identification/{customer-id}

Integra-se a outro microsserviço, recupera os dados de um cliente, monta um objeto com os dados necessários e devolve para o front.

#### ⬅ Requisição

~~~yaml
path: /customer/02302176308/identification/83014969-4800-4cc8-95eb-a2f8cd8851df
method: GET
headers:
    authorization: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6InMydy1leHBsb3Jpbmdtb2NrLWFwaSIsImlhdCI6MTUxNjIzOTAyMn0.zkNVNZrzL4pG-iXj3YEYL-vd5yUV0u3HoDy8IFKtGa8 
~~~

#### ➡ Resposta

Status: `200 Ok`
<br>
Body:
~~~json
{
  "page_title": "Confirme as suas informações",
  "page_subtitle": "Por favor, verifique se os dados estão corretos",
  "customer_name": "Talita Lopes Lima",
  "customer_document_number": "023.021.763-08",
  "customer_email_address": "talita.lopes@customer.isiflix.com.br",
  "page_continue_button_label": "Continuar",
  "page_cancel_button_label": "Meus dados não conferem",
  "page_warning_message": "Em caso de dúvidas, entre em contato com o suporte"
}
~~~

#### ⬅ Requisição

~~~yaml
path: /customer/34443942092/identification/ab9cbc88-faaf-41d4-8cf1-43e6df0139ec
method: GET
headers:
  authorization: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6InMydy1leHBsb3Jpbmdtb2NrLWFwaSIsImlhdCI6MTUxNjIzOTAyMn0.zkNVNZrzL4pG-iXj3YEYL-vd5yUV0u3HoDy8IFKtGa8 
~~~

#### ➡ Resposta

Status: `400 Bad Request`
<br>
Body:
~~~json
{
  "timestamp": "2023-03-06T22:46:12.6392979",
  "status": 400,
  "error": "BAD_REQUEST",
  "message": "Oops! It looks like something is wrong!",
  "path": "/customer/34443942092/identification/ab9cbc88-faaf-41d4-8cf1-43e6df0139ec"
}
~~~

#### ⬅ Requisição

~~~yaml
path: /customer/25511181072/identification/2291a061-3c0d-49a1-b3f6-08d9ca444629
method: GET
headers:
    authorization: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6InMydy1leHBsb3Jpbmdtb2NrLWFwaSIsImlhdCI6MTUxNjIzOTAyMn0.zkNVNZrzL4pG-iXj3YEYL-vd5yUV0u3HoDy8IFKtGa8 
~~~

#### ➡ Resposta

Status: `401 Unauthorized`
<br>
Body:
~~~json
{
  "timestamp": "2023-03-06T22:48:21.8325985",
  "status": 401,
  "error": "UNAUTHORIZED",
  "message": "Oops! It looks like you are not authorized to proceed!",
  "path": "/customer/25511181072/identification/2291a061-3c0d-49a1-b3f6-08d9ca444629"
}
~~~

#### ⬅ Requisição

~~~yaml
path: /customer/99314648010/identification/c818edcf-994f-44fc-b326-4e26470a27e0
method: GET
headers:
    authorization: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6InMydy1leHBsb3Jpbmdtb2NrLWFwaSIsImlhdCI6MTUxNjIzOTAyMn0.zkNVNZrzL4pG-iXj3YEYL-vd5yUV0u3HoDy8IFKtGa8 
~~~

#### ➡ Resposta

Status: `403 Forbidden`
<br>
Body:
~~~json
{
  "timestamp": "2023-03-06T22:49:46.6529099",
  "status": 403,
  "error": "FORBIDDEN",
  "message": "Oops! Forbidden to move forward!",
  "path": "/customer/99314648010/identification/c818edcf-994f-44fc-b326-4e26470a27e0"
}
~~~

#### ⬅ Requisição

~~~yaml
path: /customer/02738292038/identification/a7f93e8a-8a82-4707-a54b-0b84eb395d9a
method: GET
headers:
    authorization: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6InMydy1leHBsb3Jpbmdtb2NrLWFwaSIsImlhdCI6MTUxNjIzOTAyMn0.zkNVNZrzL4pG-iXj3YEYL-vd5yUV0u3HoDy8IFKtGa8 
~~~

#### ➡ Resposta

Status: `404 Not Found`
<br>
Body:
~~~json
{
  "timestamp": "2023-03-06T22:50:54.6143093",
  "status": 404,
  "error": "NOT_FOUND",
  "message": "Oops! Nothing found here!",
  "path": "/customer/02738292038/identification/a7f93e8a-8a82-4707-a54b-0b84eb395d9a"
}
~~~

#### ⬅ Requisição

~~~yaml
path: /customer/38255739076/identification/74e00e82-c129-44f9-a1de-3e7adffa03a7
method: GET
headers:
    authorization: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6InMydy1leHBsb3Jpbmdtb2NrLWFwaSIsImlhdCI6MTUxNjIzOTAyMn0.zkNVNZrzL4pG-iXj3YEYL-vd5yUV0u3HoDy8IFKtGa8 
~~~

#### ➡ Resposta

Status: `500 Internal Server Error`
<br>
Body:
~~~json
{
  "timestamp": "2023-03-06T22:52:40.9245966",
  "status": 500,
  "error": "INTERNAL_SERVER_ERROR",
  "message": "Oops! Unable to complete your request!",
  "path": "/customer/38255739076/identification/74e00e82-c129-44f9-a1de-3e7adffa03a7"
}
~~~

---

## 🧩 Integrações

As seguintes integrações são realizadas:

### 🔘 /v1/mock/message

Retorna os dados de uma mensagem.

#### ⬅ Requisição

~~~yaml
path: /v1/mock/message
method: GET
headers:
    authorization: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6InMydy1leHBsb3Jpbmdtb2NrLWFwaSIsImlhdCI6MTUxNjIzOTAyMn0.zkNVNZrzL4pG-iXj3YEYL-vd5yUV0u3HoDy8IFKtGa8 
~~~

#### ➡ Resposta

Status: `200 Ok`
<br>
Body:
~~~json
{
  "message": "Hello, Wiremock!"
}
~~~

### 🔘 /v1/mock/customer/consult/{document-number}/id/{customer-id}

Retorna os dados de um cliente.

#### ⬅ Requisição

~~~yaml
path: /v1/mock/customer/consult/02302176308/id/83014969-4800-4cc8-95eb-a2f8cd8851df
method: GET
headers:
    authorization: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6InMydy1leHBsb3Jpbmdtb2NrLWFwaSIsImlhdCI6MTUxNjIzOTAyMn0.zkNVNZrzL4pG-iXj3YEYL-vd5yUV0u3HoDy8IFKtGa8 
~~~

#### ➡ Resposta

Status: `200 Ok`
<br>
Body:
~~~json
{
  "customer_id": "83014969-4800-4cc8-95eb-a2f8cd8851df",
  "has_premium_isiflix_account": true,
  "personal_information": {
    "full_name": "Talita Lopes Lima",
    "gender": "Feminino",
    "birthday": "23/05/1995",
    "document_number": "023.021.763-08"
  },
  "contact_information": {
    "cell_phone_number": "+55 11 92618-6044",
    "phone_number": "+55 11 4988-0419",
    "email_address": "talita.lopes@customer.isiflix.com.br"
  },
  "address_information": {
    "street": "Avenida N. Sra. da Compilação",
    "number": "1621",
    "complement": "Esq. com o Spring Park",
    "neighborhood": "Morada do Bean",
    "city": "São José do Byte Code",
    "state": "SP",
    "country": "Brasil",
    "zip_code": "11017-019"
  }
}
~~~

#### ⬅ Requisição

~~~yaml
path: /v1/mock/customer/consult/34443942092/id/ab9cbc88-faaf-41d4-8cf1-43e6df0139ec
method: GET
headers:
    authorization: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6InMydy1leHBsb3Jpbmdtb2NrLWFwaSIsImlhdCI6MTUxNjIzOTAyMn0.zkNVNZrzL4pG-iXj3YEYL-vd5yUV0u3HoDy8IFKtGa8 
~~~

#### ➡ Resposta

Status: `400 Bad Request`
<br>
Body:
~~~json
{}
~~~

#### ⬅ Requisição

~~~yaml
path: /v1/mock/customer/consult/25511181072/id/2291a061-3c0d-49a1-b3f6-08d9ca444629
method: GET
headers:
    authorization: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6InMydy1leHBsb3Jpbmdtb2NrLWFwaSIsImlhdCI6MTUxNjIzOTAyMn0.zkNVNZrzL4pG-iXj3YEYL-vd5yUV0u3HoDy8IFKtGa8 
~~~

#### ➡ Resposta

Status: `401 Unauthorized`
<br>
Body:
~~~json
{}
~~~

#### ⬅ Requisição

~~~yaml
path: /v1/mock/customer/consult/99314648010/id/c818edcf-994f-44fc-b326-4e26470a27e0
method: GET
headers:
    authorization: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6InMydy1leHBsb3Jpbmdtb2NrLWFwaSIsImlhdCI6MTUxNjIzOTAyMn0.zkNVNZrzL4pG-iXj3YEYL-vd5yUV0u3HoDy8IFKtGa8 
~~~

#### ➡ Resposta

Status: `403 Forbidden`
<br>
Body:
~~~json
{}
~~~

#### ⬅ Requisição

~~~yaml
path: /v1/mock/customer/consult/02738292038/id/a7f93e8a-8a82-4707-a54b-0b84eb395d9a
method: GET
headers:
    authorization: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6InMydy1leHBsb3Jpbmdtb2NrLWFwaSIsImlhdCI6MTUxNjIzOTAyMn0.zkNVNZrzL4pG-iXj3YEYL-vd5yUV0u3HoDy8IFKtGa8 
~~~

#### ➡ Resposta

Status: `404 Not Found`
<br>
Body:
~~~json
{}
~~~

#### ⬅ Requisição

~~~yaml
path: /v1/mock/customer/consult/38255739076/id/74e00e82-c129-44f9-a1de-3e7adffa03a7
method: GET
headers:
    authorization: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6InMydy1leHBsb3Jpbmdtb2NrLWFwaSIsImlhdCI6MTUxNjIzOTAyMn0.zkNVNZrzL4pG-iXj3YEYL-vd5yUV0u3HoDy8IFKtGa8 
~~~

#### ➡ Resposta

Status: `500 Internal Server Error`
<br>
Body:
~~~json
{}
~~~

---

## 🧰 Tecnologias e recursos

As seguintes tecnologias e recursos foram utilizados no desenvolvimento da peça/projeto:

- **Kotlin**
- **Spring Boot**
- **Wiremock**

---

## 🚀 Como executar

Antes de começar, você precisará ter instalado as seguintes ferramentas em sua máquina:

- **IntelliJ** 
- **JDK 11**
- **Docker**
- **Git**

### ⏯ Executando a aplicação

Clone o repositório com o seguinte comando:

```bash
$ git clone https://github.com/WybsonSantana/s2w-exploringmock-api.git
````

Acesse a pasta do projeto pelo terminal usando o comando:

```bash
$ cd s2w-explorinmock-api
````

Com o Docker em execução, execute o arquivo `docker-compose.yml` com o seguinte comando para subir o container do Wiremock:

```bash
$ docker compose up -d
````

Agora, abra o projeto no IntelliJ e navegue até a classe principal da aplicação no seguinte caminho:

`src/main/kotlin/br/dev/s2w/exploring/mock/S2wExploringMockApiApplication.kt`

Clique no arquivo `S2wExploringMockApiApplication.kt` com o botão direito do mouse, ou tecla aplicações do teclado, e selecione a opção `Modify Run Configuration`. Agora, na janela que se abriu, navegue até o campo `VM options`e insira o seguinte parâmetro: 

`-Dspring.profiles.active=local`

Clique no botão `Aplicar` e em seguida em `OK`. Pronto! Agora a aplicação já pode ser executada com o comando `Shift + F10`.
