---
theme:
  override:
    code:
      alignment: left
title: Interface de Linha de Comando (CLI)
sub_title: Definição, Vantagens, Desvantagens e Exemplos
authors:
  - Ricardo Costa da Silva
  - Gabriel Nascimento Nogueira
  - Matheus Honorato de Menezes
---

Introdução e Definição
===
<!-- alignment: center -->
* CLI é uma das formas mais antigas de interação com computadores.
* **Definição:** Interface de Linha de Comando (CLI) permite controlar o sistema através de comandos digitados.
* Funcionamento:
    * Usuário digita comandos
    * Sistema interpreta e executa
    * Retorna resultado imediatamente
* Exemplo visual:
    * Comando: `ipconfig`
    * Retorno: 
```text
Configuração de IP do Windows

Adaptador Ethernet Ethernet 2:

   Sufixo DNS específico de conexão. . . . . . : tj.ac.gov.br
   Endereço IPv4. . . . . . . .  . . . . . . . : 172.19.6.63
   Máscara de Sub-rede . . . . . . . . . . . . : 255.255.255.0
   Gateway Padrão. . . . . . . . . . . . . . . : 172.19.6.254
```
<!-- end_slide -->

Exemplos
===
* **Terminal Linux**
```bash
echo hello world
ls -la
```
* **Prompt de Comando (Windows)**
```bat
dir
echo Hello World
```
* **PowerShell**
```powershell
Get-ChildItem
Write-Output "Hello World"
```
* **Git**
```bash
git status
git commit -m "Hello World"
```
* **Roteadores e switches**
```cli
show running-config
ping 192.168.1.1
```
Nota: todos seguem a mesma lógica, mas comandos variam por sistema.
<!-- end_slide -->

Vantagens
===
* Rapidez: execução imediata de tarefas.
* Leveza: consome poucos recursos do sistema.
* Automação: scripts permitem repetição de tarefas sem intervenção manual.
* Acesso remoto: ideal para administrar servidores e dispositivos em rede.
* Flexibilidade: combina comandos, scripts e ferramentas externas.
<!-- end_slide -->

Limitações
===
* Curva de aprendizado alta
* Pouco intuitiva
* Maior risco de erros graves
* Exemplo de comando perigoso:
```bash
rm -rf / # perigo de apagar tudo
```

Aplicação Inovadora
===
* CLI com **IA integrada**:
    * Interpreta linguagem natural
    * Tradução em comandos técnicos automaticamente
    * Facilita uso para iniciantes
* Exemplo: "Crie pasta X e baixe arquivos Y" → CLI executa comandos:
```bash
mkdir X
cd X
wget http://exemplo.com/arquivo
```
<!-- end_slide -->

Conclusão
===
* CLI: Poder e Velocidade
    * Controle total do sistema de forma rápida e eficiente.
* Aplicações e Vantagens
    * Presente em múltiplos sistemas, ideal para automação.
* Limitações e Futuro
    * A curva de aprendizado existe, mas a IA pode reduzir as barreiras.
* Habilidade Essencial
    * O domínio da CLI é crucial para o profissional de TI.
<!-- end_slide -->

Obrigado pela atenção!
===
<!-- alignment: center -->
# Perguntas?