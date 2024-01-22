# banco_api_simples

Este é uma simples API RESTful de transação entre usuários desenvolvido com Spring Boot. O projeto foi tema operações como criar um usuário, consultar usuário, fazer transações de valores entre usuários e histórico de transação entre os usuários. Tendo duas entidades `Usuario` e `Transacao`.

## Endpoints

#### 1. Criar Usuário:
    POST /user
    
    Corpo da Requisição:
    json
        {
           "nome": "NOME DO USUÁRIO",
           "email": "O EMAIL DO USUÁRIO",
           "senha": "SENHA DO USUÁRIO"
        }
#### 2. Consultar Usuário:
    (retorna todos os usuários):
    GET /user 
    
    (retorna apenas o que você buscou no parâmetro):
    GET /user?seach=NOME_DO_USUÁRIO 

#### 3. Transação Entre Usuário:

    GET /transacao?valor=(VALOR TIPO FLOAT)&remetente=(ID DO REMETENTE)&destinatario=(ID DO DESTINATARIO)
    
    EX:
    GET /transacao?valor=42.54&remetente=1&destinatario=5
    
#### 4. Histórico de transação:

    GET /transacao/historico
