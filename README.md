# projeto_aha
Sistema de Alocação de Horários Acadêmicos


Dicas de Formatação

  <style>
    #formSalvarProduto input{width: 100%};
  </style>

Comando Oracle

SELECT a.cd_lotacao
FROM TB_LOTACAO_INTEGRADA a
  START WITH CD_LOTACAO       = 50000056
  CONNECT BY PRIOR CD_LOTACAO = CD_LOTACAO_SUP;
