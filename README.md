const markdown = `
# Testes Unitários com Jest no Angular – O Guia Definitivo

Neste artigo, iremos aprender um pouco sobre testes unitários utilizando um framework extremamente poderoso, o **Jest**! Vamos juntos nessa aventura?

![TESTES UNITÁRIOS](imagem.png)  
_(Imagem contendo a escrita "TESTES UNITÁRIOS", seguido das imagens do Angular e do Jest, juntamente com a frase "O GUIA DEFINITIVO")_

---

## 1 — A Importância dos Testes Unitários

Os testes unitários são extremamente essenciais para manter a **legibilidade** e **qualidade do código**. Com eles, podemos:

- Detectar erros de forma mais rápida.
- Documentar melhor o código.
- Compreender melhor a regra de negócio que o código expressa.

---

## 2 — Testes Unitários e a Pirâmide de Testes

A **Pirâmide de Testes** é uma representação visual que ilustra os tipos de testes, seus níveis, tempo de implementação e custos.

Ela é dividida em três camadas:

- **Base** → Testes Unitários (foco deste artigo).  
- **Meio** → Testes de Integração.  
- **Topo** → Testes End-to-End (E2E).  

Os **Testes Unitários** são os mais rápidos e baratos de implementar. Eles verificam **métodos, classes e componentes** individualmente. Para isso, usamos **Mocks**, que simulam retornos de API, variáveis e estados.

A **pirâmide de testes de software** é fundamental para garantir a qualidade e eficiência dos testes.

---

## 3 — O Jest

O **Jest** é um **framework de testes unitários** amplamente utilizado na comunidade JavaScript, principalmente em aplicações **Angular, React e Vue**.  
Ele oferece:

✅ Configuração simples  
✅ Suporte a Mocks  
✅ Isolamento de testes  
✅ Relatórios detalhados  

---

## 4 — Mão na Massa

Vamos testar uma **aplicação Angular** que consulta um endereço via CEP. Os testes serão aplicados em:

- **Componentes**
- **Services (Chamadas HTTP)**
- **Pipes**

### 4.1 — Testando Componentes

Temos o componente `EnderecoComponent`, que usa um método do serviço `EnderecoService`.

Sempre que geramos um componente, o Angular já cria um teste unitário inicial para verificar se a instância do componente foi inicializada.

### Principais importações:

```typescript
import { ComponentFixture, TestBed } from '@angular/core/testing';
```

- **ComponentFixture**: Classe utilitária do Angular usada para criar um ambiente de teste para um componente.  
- **TestBed**: Classe que age como um ambiente de teste dinâmico no Angular, permitindo configurar e inicializar módulos e componentes.

### Funções do Jest:

- **describe**: Agrupa uma suíte de testes relacionados.  
- **it**: Define um teste individual.  
- **beforeEach**: Executa o código antes de cada teste, permitindo configurações prévias.

### Configuração do módulo de teste:

```typescript
beforeEach(async () => {
  await TestBed.configureTestingModule({
    declarations: [EnderecoComponent],
    providers: [EnderecoService]
  }).compileComponents();
});
```

Aqui, declaramos componentes e importamos módulos necessários.

### Testando o método `buscarEndereco()`

1. Adicionar o módulo `HttpClientTestingModule` e declarar o `EnderecoService` nos providers.
2. Criar um mock para o retorno da chamada do serviço.
3. Criar um **Spy** para o método `buscarEndereco()` do `EnderecoService`, substituindo seu retorno.

```typescript
spyOn(enderecoService, 'buscarEndereco').and.returnValue(of(mockEndereco));
```

4. Simular a entrada do CEP e chamar `buscarEndereco()`.
5. Verificar se os resultados estão corretos:

```typescript
expect(component.endereco).toEqual(mockEndereco);
expect(enderecoService.buscarEndereco).toHaveBeenCalledTimes(1);
```

Com isso, validamos o principal método do nosso componente! 🚀

---

### 4.2 — Testando Services

Agora, vamos testar o serviço `EnderecoService`, que realiza uma chamada HTTP para buscar um endereço via CEP.

#### Configuração:

```typescript
beforeEach(() => {
  TestBed.configureTestingModule({
    imports: [HttpClientTestingModule],
    providers: [EnderecoService]
  });
});
```

#### Testando o método `buscarEndereco()`

Aqui, utilizamos um **mock para o HttpClient**:

```typescript
spyOn(httpClient, 'get').and.returnValue(of(mockEndereco));
```

Após chamar o método `buscarEndereco()`, verificamos:

- Se o retorno foi igual ao esperado:
  
  ```typescript
  expect(resultado).toEqual(mockEndereco);
  ```

- Se o método **get** do `HttpClient` foi chamado corretamente:

  ```typescript
  expect(httpClient.get).toHaveBeenCalledWith('https://api.exemplo.com/cep/57080000');
  ```

---

### 4.3 — Testando Pipes

Criamos um **Pipe** customizado para formatar CEPs. Esse pipe possui diversos cenários de entrada e saída, que devem ser testados.

#### Exemplo de Teste:

```typescript
it('deve formatar corretamente um CEP', () => {
  expect(pipe.transform('57080000')).toBe('57080-000');
});
```

Os testes de **Pipes** costumam ser mais simples e exigem menos configurações.

---

## Conclusão

Espero ter ajudado um pouco na sua jornada com **testes unitários no Angular com Jest**! 🚀  
Se tiver dúvidas, consulte a documentação oficial:

📌 **Documentação do Jest**: [https://jestjs.io/pt-BR/docs/getting-started](https://jestjs.io/pt-BR/docs/getting-started)

Até mais! 👋
`;
