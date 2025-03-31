#define MAX 10

// Struct - lista encadeada pessoa
struct pessoa {
    int id;
    char nome[80];
    float peso;
    int idade;
    struct pessoa* prox;
}; // Fim da struct pessoa

typedef struct pessoa Pessoa;

typedef struct {
	char nome[80];
	Pessoa pessoas[MAX];
} Lista;

// Função criarLista()
Pessoa* criarLista() {
    return NULL;
} // Fim da funçãoo criarLista()

// Função inserirLista() - inserir um novo elemento na lista
Pessoa* inserirLista(Pessoa* p, int novoId, char *novoNome, float novoPeso, int novaIdade) {
    Pessoa* novo = (Pessoa*)malloc(sizeof(Pessoa));
    if (novo == NULL) {
        printf("Erro ao alocar mem�ria! N�o ser� poss�vel inserir novo elemento na lista!\n");
        exit(1);
    }
    novo->id = novoId;
    strcpy(novo->nome, novoNome);
    novo->peso = novoPeso;
    novo->idade = novaIdade;
    novo->prox = p;
    return novo;
} // Fim da função inserirLista()

// Procedimento imprimirLista()
void imprimirLista(Pessoa* p) {
    Pessoa* pe;
    for (pe = p; pe != NULL; pe = pe->prox) {
        printf("\n\n\n\tCadastro de Pessoa");
        printf("\n\nId da pessoa: %d", pe->id);
        printf("\nNome da pessoa: %s", pe->nome);
        printf("\nPeso da pessoa (kg): %.2f", pe->peso);
        printf("\nIdade da pessoa (anos completos): %d", pe->idade);
    }
} // Fim da função imprimirLista()

// Função buscaElemento()
Pessoa* buscaElemento(Pessoa* p, int codBusca) {
    Pessoa* pe;
    for (pe = p; pe != NULL; pe = pe->prox) {
        if (pe->id == codBusca) {
            return pe;
        }
    }
    return NULL;
} // Fim da função buscaElemento()

// Função listaVazia()
int listaVazia(Pessoa* p) {
    return p == NULL; //Verdadeiro ou falso direto
} // Fim da listaVazia()

// Função removerElemento()
Pessoa* removerElemento(Pessoa* p, int codBusca) {
    Pessoa* pe = p;
    Pessoa* ant = NULL;

    while (pe != NULL && pe->id != codBusca) {
        ant = pe;
        pe = pe->prox;
    }

    // Lista est� vazia ou o elemento com codBusca n�o foi localizado
    if (pe == NULL)
        return p;

    // Elemento localizado na lista
    if (ant == NULL) // Elemento removido � o "primeiro"
        p = pe->prox;
    else
        ant->prox = pe->prox;

    free(pe);
    return p;
} // Fim da função removerElemento()

// Função liberarLista()
Pessoa* liberarLista(Pessoa* p) {
    Pessoa* pe = p;
    while (pe != NULL) {
        Pessoa* p1 = pe->prox;
        free(pe);
        pe = p1;
    }
    return NULL;
} // Fim da função liberarLista()

// Função compararListas() - Compara��o com base no id
int compararListas(Pessoa* p1, Pessoa* p2) {
    Pessoa* pe1 = p1;
    Pessoa* pe2 = p2;
    while (pe1 != NULL && pe2 != NULL) {
        if (pe1->id != pe2->id)
            return 0;
        pe1 = pe1->prox;
        pe2 = pe2->prox;
    }
    return pe1 == pe2; // NULL == NULL
} // Fim da função compararListas()

int compararPessoa(Pessoa* lista, int campo) {
    int contador = 0;
    Pessoa* atual = lista;

    switch (campo) {
        case 1: { // Buscar por ID
            int id;
            printf("\n\nInforme o ID que deseja buscar: ");
            scanf("%d", &id);
            while (atual != NULL) {
                if (atual->id == id) {
                    contador++;
                }
                atual = atual->prox;
            }
            break;
        }
        case 2: { // Buscar por Nome
            char nome[80];
            printf("\n\nInforme o nome que deseja buscar: ");
            scanf(" %[^\n]s", nome);
            while (atual != NULL) {
                if (strcmp(atual->nome, nome) == 0) {
                    contador++;
                    printf("\n\nNome encontrado no registro com ID %d", atual->id);
                }
                atual = atual->prox;
            }
            break;
        }
        case 3: { // Buscar por Peso
            float peso;
            printf("\n\nInforme o peso que deseja buscar: ");
            scanf("%f", &peso);
            while (atual != NULL) {
                if (atual->peso == peso) {
                    contador++;
                    printf("\n\nPeso encontrado no registro com ID %d", atual->id);
                }
                atual = atual->prox;
            }
            break;
        }
        case 4: { // Buscar por Idade
            int idade;
            printf("\n\nInforme a idade que deseja buscar: ");
            scanf("%d", &idade);
            while (atual != NULL) {
                if (atual->idade == idade) {
                    contador++;
                    printf("\n\nIdade encontrada no registro com ID %d", atual->id);
                }
                atual = atual->prox;
            }
            break;
        }
        default:
            return -1; // Retorna -1 para indicar erro
    }

    // printf("\n\nQuantidade de registros encontrados: %d\n", contador);
    return contador;
}

// Função ordenarLista() - Crescente
Pessoa* ordenarLista(Pessoa* lista) {
    if (lista == NULL || lista->prox == NULL) {
        return lista; // Lista vazia ou com apenas um elemento já está ordenada
    }

    Pessoa* atual = lista;

    while (atual != NULL) {
        Pessoa* menor = atual;
        Pessoa* aux = atual->prox;

        while (aux != NULL) {
            if (aux->id < menor->id) {
                menor = aux;
            }
            aux = aux->prox;
        }

        if (menor != atual) {
            int tempId = atual->id;
            atual->id = menor->id;
            menor->id = tempId;

            char tempNome[80];
            strcpy(tempNome, atual->nome);
            strcpy(atual->nome, menor->nome);
            strcpy(menor->nome, tempNome);

            float tempPeso = atual->peso;
            atual->peso = menor->peso;
            menor->peso = tempPeso;

            int tempIdade = atual->idade;
            atual->idade = menor->idade;
            menor->idade = tempIdade;
        }

        atual = atual->prox;
    }

    return lista;
}//Fim Função ordenarLista()

//Função editarRegistro()
void editarRegistro(Pessoa* lista, int id, char* novoNome, float novoPeso, int novaIdade) {
    Pessoa* p = buscaElemento(lista, id);
    if (p == NULL) {
        printf("\n\n\nRegistro com ID %d não encontrado.", id);
        return;
    }
    if (novoNome != NULL && strlen(novoNome) > 0) {
        strcpy(p->nome, novoNome);
    }
    if (novoPeso >= 0) {
        p->peso = novoPeso;
    }
    if (novaIdade >= 0) {
        p->idade = novaIdade;
    }

    printf("\n\n\nRegistro com ID %d atualizado com sucesso.", id);
}//Fim da função editarResgistro()
