/*
*	Autor: Iosif Radu-Marius
*	Grupa: 30223
*	Data incepere prioect: 18.05.2020
*	Data finalizare: 23.05.2020
*
*	Cerinta:
*
*	Reactia care trebuie simulata este:
*		Li2O + 2NaCl ---> 2LiCl + Na2O
*	Deci initial se creeaza threadurile care simuleaza atomii de Li, O, Na, Cl
*	Acesti atomi vor forma moleculele Li2O + 2NaCl  
*	care vor intra in reactie si formeaza moleculele: 2LiCl + Na2O
*	Conditia de terminare: daca s-au format N molecule de LiCl
*	N se specifica ca si argument din linia de comanda.
*
*	Mod de implementare: 
*	
*	Am ales sa folosesc 10 semafoare, dintre care unul principal pentru mapare, cate unul pentru fiecare atom si 
*	molecula precum si o bariera pentru atomi si cate o bariera pentru fiecare molecula. Maparea am realizat-o intr-un union de structuri.
*	Threadurile create le-am memorat in 3 vectori alocati dinamic, unul pentru atomi si unul pentru fiecare molecula, iar in main le-am dat join.
*	La finalul executiei programului, memoria acestora a fost eliberata.
*
*	Mod de compilare: gcc t2.c -o t2 -lpthread
*	Mod de rulare: ./t2 N, unde N reprezinta conditia de oprire, anume momentul in care s-au format 2 molecule de LiCl, adica dupa 
*	dupa N / 2 reactii. in cazul in care N este impar(de exemplu 5), programul va genera o molecula in plus, data fiind forma reactiei 
*	(adica va realiza 3 reactii si va genera 6 molecule de LiCl).
*
*	Probleme: -> incercarea de a aloca dinamic vectorii de threaduri, realocarea memoriei si eliberarea acesteia la finalul executiei a
*				esuat si am trecut la alocarea statica.
*			  -> transmitere sirurilor de cuvinte ca parametrii la threaduri. Am recurs la folosirea unui struct format din int si char.
*/


#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <semaphore.h>
#include <pthread.h>
#include <time.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <sys/mman.h>
#include <sys/time.h>   
#include <sys/resource.h> 
#include <fcntl.h>

//argumentul N
int N;

//threaduri
pthread_t threadLi;
pthread_t threadO;
pthread_t threadNa;
pthread_t threadCl;
pthread_t threadLi2O;
pthread_t threadNaCl;

//semafoare
sem_t barieraMolecula;
sem_t barieraAtomiLiO;
sem_t barieraAtomiNaCl;
sem_t semaforOxigen;
sem_t semaforLitiu;
sem_t semaforSodiu;
sem_t semaforClor;
sem_t semaforLi2O;
sem_t semaforNaCl;
sem_t excludereMutuala;

//id-uri atomi
int litiuID = 0;
int oxigenID = 0;
int clorID = 0;
int sodiuID = 0;

//id-uri molecule
int Li2OID = 0;
int NaClID = 0;

//contoare atomi
int atomiLitiu = 0;
int atomiOxigen = 0;
int atomiSodiu = 0;
int atomiClor = 0;

//contoare molecule
int moleculaLi2O = 0;
int moleculaNaCl = 0;

//contoare reactie
int contorReactie = 0;

//contor threaduri
int contorThread = 0;
int contorThreadNaCl = 0;
int contorThreadLi2O = 0;

//contor union
int contorUnion = 0;
int contorCreareTerminareAtom = 0;
int contorFormare = 0;
int contorTerminareMolecula = 0;
int contorCondFinal = 0;


//numarul de molecule de LiCl
int N = 2;

//vectori threaduri
pthread_t vectorThreaduri[1000];
pthread_t vectorThreaduriNaCl[1000];
pthread_t vectorThreaduriLi2O[1000];

//structuri de date

struct timespec currentTime;

typedef struct CREARE {
	char tipAtom[3];
	int idAtom;
	long momentDeTimp;
} creare_atom;

typedef struct FORMARE {
	char tipMolecula[5];
	int nrMolecula;
	char tipAtom[3];
	int idAtom;
	long momentDeTimp;
} formare_molecula;

typedef struct REACTIE {
	char tipReactie[30];
	int nrReactie;
	char tipMolecula[5];
	int nrMolecula;
	long momentDeTimp;
} reactie;

typedef struct TERMINARE_ATOM {
	char tipAtom[3];
	int idAtom;
	long momentDeTimp;
} terminare_atom;

typedef struct TERMINARE_MOLECULA {
	char tipMolecula[5];
	int nrMolecula;
	long momentDeTimp;
} terminare_molecula;

typedef struct CONDITIE_DE_FINAL { 
	long momentDeTimp;
} conditie_de_final;

union structs_union {
	creare_atom creareAtom;
	formare_molecula formareMolecula;
	reactie reactie;
	terminare_atom terminareAtom;
	terminare_molecula terminareMolecula;
	conditie_de_final conditieDeFinal;
};

union structs_union* vectorUnionStructuri;

struct argsThreadMolecula {
	char* tip;
	int id;
};

/* molecule -> pentru evitarea duplicarii antetelor fiecarei functii am ales sa pozitionez de fiecare data functiile pe care le apelez
*			  inaintea functiilor in care sunt apelate.
*			-> pentru molecule, avem 3 tipuri de mapari: una la crearea molecului, una la formarea reactiei (daca este cazul) si una la 
*			  terminarea moleculei.
*			-> din threadurile pentru atomi, au fost transmise sub forma unei structuri de date ajutatoare tipul si id-ul atomului din
*			  care se formeaza reactia. (PS: am incercat si vector de cuvinte sa transmit si sa il parsez, dar nu am reusit. se 
*			  se transmiteau caractere nonascii).
*/

/*
*	Conditia de formare a reactiei este sa existe cel putin doua molecule de NaCl.
*/
void* Li2O(void* args) {
	sem_wait(&barieraMolecula);

	Li2OID++;
	sem_wait(&excludereMutuala);

	strcpy(vectorUnionStructuri[contorUnion].formareMolecula.tipMolecula, "Li2O");
	vectorUnionStructuri[contorUnion].formareMolecula.nrMolecula = Li2OID;
	strcpy(vectorUnionStructuri[contorUnion].formareMolecula.tipAtom, ((struct argsThreadMolecula*)args)->tip);
	vectorUnionStructuri[contorUnion].formareMolecula.idAtom = ((struct argsThreadMolecula*)args)->id;
	clock_gettime(CLOCK_MONOTONIC, &currentTime);
	vectorUnionStructuri[contorUnion].formareMolecula.momentDeTimp = currentTime.tv_nsec;
	contorUnion++;
	contorFormare++;

	sem_post(&excludereMutuala);

	if (moleculaNaCl > 1) {
		moleculaNaCl -= 2;
		sem_post(&semaforNaCl);
		sem_post(&semaforNaCl);

		sem_post(&barieraMolecula);

		sem_wait(&excludereMutuala);

		strcpy(vectorUnionStructuri[contorUnion].reactie.tipReactie, "Li2O + 2NaCl ---> 2LiCl + Na2O");
		vectorUnionStructuri[contorUnion].reactie.nrReactie = contorReactie;
		strcpy(vectorUnionStructuri[contorUnion].reactie.tipMolecula, "Li2O");
		vectorUnionStructuri[contorUnion].reactie.nrMolecula = Li2OID;
		clock_gettime(CLOCK_MONOTONIC, &currentTime);
		vectorUnionStructuri[contorUnion].reactie.momentDeTimp = currentTime.tv_nsec;
		contorUnion++;

		sem_post(&excludereMutuala);

		contorReactie++;
	}
	else {
		moleculaLi2O++;

		sem_post(&barieraMolecula);

		sem_wait(&semaforLi2O);
	}

	sem_wait(&excludereMutuala);

	strcpy(vectorUnionStructuri[contorUnion].terminareMolecula.tipMolecula, "Li2O");
	vectorUnionStructuri[contorUnion].terminareMolecula.nrMolecula = Li2OID;
	clock_gettime(CLOCK_MONOTONIC, &currentTime);
	vectorUnionStructuri[contorUnion].terminareMolecula.momentDeTimp = currentTime.tv_nsec;
	contorUnion++;
	contorTerminareMolecula++;

	sem_post(&excludereMutuala);
}

/*
*	Conditia de formare a reactie este sa existe cel putin o molecula de Li20 si una de NaCl.
*/

void* NaCl(void* args) {
	sem_wait(&barieraMolecula);

	NaClID++;
	sem_wait(&excludereMutuala);

	strcpy(vectorUnionStructuri[contorUnion].formareMolecula.tipMolecula, "NaCl");
	vectorUnionStructuri[contorUnion].formareMolecula.nrMolecula = NaClID;
	strcpy(vectorUnionStructuri[contorUnion].formareMolecula.tipAtom, ((struct argsThreadMolecula*)args)->tip);
	vectorUnionStructuri[contorUnion].formareMolecula.idAtom = ((struct argsThreadMolecula*)args)->id;
	clock_gettime(CLOCK_MONOTONIC, &currentTime);
	vectorUnionStructuri[contorUnion].formareMolecula.momentDeTimp = currentTime.tv_nsec;
	contorUnion++;
	contorFormare++;

	sem_post(&excludereMutuala);
	

	if (moleculaLi2O > 0 && moleculaNaCl > 0) {
		moleculaLi2O--;
		sem_post(&semaforLi2O);

		moleculaNaCl--;
		sem_post(&semaforNaCl);

		sem_post(&barieraMolecula);

		sem_wait(&excludereMutuala);

		strcpy(vectorUnionStructuri[contorUnion].reactie.tipReactie, "Li2O + 2NaCl ---> 2LiCl + Na2O");
		vectorUnionStructuri[contorUnion].reactie.nrReactie = contorReactie;
		strcpy(vectorUnionStructuri[contorUnion].reactie.tipMolecula, "NaCl");
		vectorUnionStructuri[contorUnion].reactie.nrMolecula = NaClID;
		clock_gettime(CLOCK_MONOTONIC, &currentTime);
		vectorUnionStructuri[contorUnion].reactie.momentDeTimp = currentTime.tv_nsec;
		contorUnion++;

		sem_post(&excludereMutuala);

		contorReactie++;
	}
	else {
		moleculaNaCl++;

		sem_post(&barieraMolecula);

		sem_wait(&semaforNaCl);
	}

	sem_wait(&excludereMutuala);

	strcpy(vectorUnionStructuri[contorUnion].terminareMolecula.tipMolecula, "NaCl");
	vectorUnionStructuri[contorUnion].terminareMolecula.nrMolecula = NaClID;
	clock_gettime(CLOCK_MONOTONIC, &currentTime);
	vectorUnionStructuri[contorUnion].terminareMolecula.momentDeTimp = currentTime.tv_nsec;
	contorUnion++;
	contorTerminareMolecula++;

	sem_post(&excludereMutuala);
}


/* atomi -> pentru atomi exista 2 tipuri de mapari: cea de generare atom si cea de terminare crearea atom.
*		 -> variabila stringAjutator, este o structura de date formata dintr-un char de 3 si un int, pentru memorarea tipului de atom
*		   si id-ul acestuia. Aceasta variabila o sa fie transmisa ca parametru threadului pentru molecula.
*/

/*
*	Conditia de creare a unei molecule de Li2O este sa existe cel putin un atom de litiu si un atom de oxigen.
*/
void* litiu(void* args) {
	sem_wait(&barieraAtomiLiO);

	litiuID++;
	sem_wait(&excludereMutuala);

	strcpy(vectorUnionStructuri[contorUnion].creareAtom.tipAtom, "Li");
	vectorUnionStructuri[contorUnion].creareAtom.idAtom = litiuID;
	clock_gettime(CLOCK_MONOTONIC, &currentTime);
	vectorUnionStructuri[contorUnion].creareAtom.momentDeTimp = currentTime.tv_nsec;
	contorUnion++;
	contorCreareTerminareAtom++;

	sem_post(&excludereMutuala);
	
	if (atomiLitiu > 0 && atomiOxigen > 0) {
		atomiOxigen--;
		sem_post(&semaforOxigen);

		atomiLitiu--;
		sem_post(&semaforLitiu);

		sem_post(&barieraAtomiLiO);

		struct argsThreadMolecula *structAjutator = (struct argsThreadMolecula*) malloc(sizeof(struct argsThreadMolecula));
		char tipAtom[] = "Li";
		structAjutator->tip = tipAtom;
		structAjutator->id = litiuID;
		
		if (pthread_create(&vectorThreaduriLi2O[contorThreadLi2O++], NULL, &Li2O, (void *) structAjutator) != 0) {
			printf("Eroare la creare molecula Li2O");
			return NULL;
		}
	}
	else {
		atomiLitiu++;

		sem_post(&barieraAtomiLiO);

		sem_wait(&semaforLitiu);
	}

	sem_wait(&excludereMutuala);

	strcpy(vectorUnionStructuri[contorUnion].terminareAtom.tipAtom, "Li");
	vectorUnionStructuri[contorUnion].terminareAtom.idAtom = litiuID;
	clock_gettime(CLOCK_MONOTONIC, &currentTime);
	vectorUnionStructuri[contorUnion].terminareAtom.momentDeTimp = currentTime.tv_nsec;
	contorUnion++;
	contorCreareTerminareAtom++;

	sem_post(&excludereMutuala);
}

/*
*	Conditia de creare a unei molecule de Li2O este sa existe cel putin doi atomi de litiu.
*/
void* oxigen(void* args) {
	sem_wait(&barieraAtomiLiO);

	oxigenID++;
	sem_wait(&excludereMutuala);

	strcpy(vectorUnionStructuri[contorUnion].creareAtom.tipAtom, "O");
	vectorUnionStructuri[contorUnion].creareAtom.idAtom = oxigenID;
	clock_gettime(CLOCK_MONOTONIC, &currentTime);
	vectorUnionStructuri[contorUnion].creareAtom.momentDeTimp = currentTime.tv_nsec;
	contorUnion++;
	contorCreareTerminareAtom++;

	sem_post(&excludereMutuala);
	
	if (atomiLitiu > 1) {
		atomiLitiu -= 2;
		sem_post(&semaforLitiu);
		sem_post(&semaforLitiu);

		sem_post(&barieraAtomiLiO);

		struct argsThreadMolecula *structAjutator = (struct argsThreadMolecula*) malloc(sizeof(struct argsThreadMolecula));
		char tipAtom[] = "O";
		structAjutator->tip = tipAtom;
		structAjutator->id = litiuID;
		
		if (pthread_create(&vectorThreaduriLi2O[contorThreadLi2O++], NULL, &Li2O, (void *) structAjutator) != 0) {
			printf("Eroare la creare molecula Li2O");
			return NULL;
		}
	}
	else {
		atomiOxigen++;

		sem_post(&barieraAtomiLiO);

		sem_wait(&semaforOxigen);
	}

	sem_wait(&excludereMutuala);

	strcpy(vectorUnionStructuri[contorUnion].terminareAtom.tipAtom, "O");
	vectorUnionStructuri[contorUnion].terminareAtom.idAtom = oxigenID;
	clock_gettime(CLOCK_MONOTONIC, &currentTime);
	vectorUnionStructuri[contorUnion].terminareAtom.momentDeTimp = currentTime.tv_nsec;
	contorUnion++;
	contorCreareTerminareAtom++;

	sem_post(&excludereMutuala);
}

/*
*	Conditia de creare a unei molecule de NaCl este sa existe cel putin un atom de clor.
*/
void* sodiu(void* args) {
	sem_wait(&barieraAtomiNaCl);

	sodiuID++;
	sem_wait(&excludereMutuala);

	strcpy(vectorUnionStructuri[contorUnion].creareAtom.tipAtom, "Na");
	vectorUnionStructuri[contorUnion].creareAtom.idAtom = sodiuID;
	clock_gettime(CLOCK_MONOTONIC, &currentTime);
	vectorUnionStructuri[contorUnion].creareAtom.momentDeTimp = currentTime.tv_nsec;
	contorUnion++;
	contorCreareTerminareAtom++;

	sem_post(&excludereMutuala);

	if (atomiClor > 0) {
		atomiClor--;
		sem_post(&semaforClor);

		sem_post(&barieraAtomiNaCl);

		struct argsThreadMolecula *structAjutator = (struct argsThreadMolecula*) malloc(sizeof(struct argsThreadMolecula));
		char tipAtom[] = "Na";
		structAjutator->tip = tipAtom;
		structAjutator->id = litiuID;
		
		if (pthread_create(&vectorThreaduriNaCl[contorThreadNaCl++], NULL, &NaCl, (void *) structAjutator) != 0) {
			printf("Eroare la creare molecula NaCl");
			return NULL;
		}
	}
	else {
		atomiSodiu++;

		sem_post(&barieraAtomiNaCl);

		sem_wait(&semaforSodiu);
	}

	sem_wait(&excludereMutuala);

	strcpy(vectorUnionStructuri[contorUnion].terminareAtom.tipAtom, "Na");
	vectorUnionStructuri[contorUnion].terminareAtom.idAtom = sodiuID;
	clock_gettime(CLOCK_MONOTONIC, &currentTime);
	vectorUnionStructuri[contorUnion].terminareAtom.momentDeTimp = currentTime.tv_nsec;
	contorUnion++;
	contorCreareTerminareAtom++;

	sem_post(&excludereMutuala);
}

/*
*	Conditia de creare a unei molecule de NaCl este sa existe cel putin un atom de sodiu.
*/
void* clor(void* args) {
	sem_wait(&barieraAtomiNaCl);

	clorID++;
	sem_wait(&excludereMutuala);

	strcpy(vectorUnionStructuri[contorUnion].creareAtom.tipAtom, "Cl");
	vectorUnionStructuri[contorUnion].creareAtom.idAtom = clorID;
	clock_gettime(CLOCK_MONOTONIC, &currentTime);
	vectorUnionStructuri[contorUnion].creareAtom.momentDeTimp = currentTime.tv_nsec;
	contorUnion++;
	contorCreareTerminareAtom++;

	sem_post(&excludereMutuala);

	if (atomiSodiu > 0) {
		atomiSodiu--;
		sem_post(&semaforSodiu);

		sem_post(&barieraAtomiNaCl);

		struct argsThreadMolecula *structAjutator = (struct argsThreadMolecula*) malloc(sizeof(struct argsThreadMolecula));
		char tipAtom[] = "Cl";
		structAjutator->tip = tipAtom;
		structAjutator->id = litiuID;
		
		if (pthread_create(&vectorThreaduriNaCl[contorThreadNaCl++], NULL, &NaCl, (void *) structAjutator) != 0) {
			printf("Eroare la creare molecula NaCl");
			return NULL;
		}
	}
	else {
		atomiClor++;

		sem_post(&barieraAtomiNaCl);

		sem_wait(&semaforClor);
	}

	sem_wait(&excludereMutuala);

	strcpy(vectorUnionStructuri[contorUnion].terminareAtom.tipAtom, "Cl");
	vectorUnionStructuri[contorUnion].terminareAtom.idAtom = clorID;
	clock_gettime(CLOCK_MONOTONIC, &currentTime);
	vectorUnionStructuri[contorUnion].terminareAtom.momentDeTimp = currentTime.tv_nsec;
	contorUnion++;
	contorCreareTerminareAtom++;

	sem_post(&excludereMutuala);
}

/*
*	creare atomi -> aceste functii incearca sa creeze atomi (threaduri pentru atomi) la infinit.
*				 -> conditia de oprire o constituie momentul in care numarul reactiilor inmultit cu 2 este mai mare sau egal cu N-ul
*				   dat ca parametru la executia programului.
*				 -> aici avem de a face doar cu un tip de mapare, aceea pentru momentul in care s-a ajuns la conditia de final.
*/
void* creareLitiu(void* args) {
	while(1) {
		sleep(1);
		if (2 * contorReactie >= N) {
			sem_wait(&excludereMutuala);

			clock_gettime(CLOCK_MONOTONIC, &currentTime);
			vectorUnionStructuri[contorUnion].conditieDeFinal.momentDeTimp = currentTime.tv_nsec;
			contorUnion++;
			contorCondFinal++;

			sem_post(&excludereMutuala);

			return NULL;
		}
		
		if (pthread_create(&vectorThreaduri[contorThread++], NULL, &litiu, NULL) != 0) {
			printf("Eroare la creare atom litiu.\n");
			exit(1);
		}
	}
}

void* creareOxigen(void* args) {
	while(1) {
		sleep(1);
		if (2 * contorReactie >= N) {
			sem_wait(&excludereMutuala);

			clock_gettime(CLOCK_MONOTONIC, &currentTime);
			vectorUnionStructuri[contorUnion].conditieDeFinal.momentDeTimp = currentTime.tv_nsec;
			contorUnion++;
			contorCondFinal++;
			
			sem_post(&excludereMutuala);

			return NULL;
		}

		if (pthread_create(&vectorThreaduri[contorThread++], NULL, &oxigen, NULL) != 0) {
			printf("Eroare la creare atom oxigen.\n");
			exit(1);
		}
	}
}

void* creareSodiu(void* args) {
	while(1) {
		sleep(1);
		if (2 * contorReactie >= N) {
			sem_wait(&excludereMutuala);

			clock_gettime(CLOCK_MONOTONIC, &currentTime);
			vectorUnionStructuri[contorUnion].conditieDeFinal.momentDeTimp = currentTime.tv_nsec;
			contorUnion++;
			contorCondFinal++;
			
			sem_post(&excludereMutuala);

			return NULL;
		}

		if (pthread_create(&vectorThreaduri[contorThread++], NULL, &sodiu, NULL) != 0) {
			printf("Eroare la creare atom sodiu.\n");
			exit(1);
		}
	}
}

void* creareClor(void* args) {
	while(1) {
		sleep(1);
		if (2 * contorReactie >= N) {
			sem_wait(&excludereMutuala);

			clock_gettime(CLOCK_MONOTONIC, &currentTime);
			vectorUnionStructuri[contorUnion].conditieDeFinal.momentDeTimp = currentTime.tv_nsec;
			contorUnion++;
			contorCondFinal++;
			
			sem_post(&excludereMutuala);

			return NULL;
		}

		if (pthread_create(&vectorThreaduri[contorThread++], NULL, &clor, NULL) != 0) {
			printf("Eroare la creare atom clor.\n");
			exit(1);
		}
	}
}

/*
*	Validarea argumentului dat ca parametru. Acesta trebuie sa fie obligatoriu numar natural.
*/
int isNumber(char* str) {

	int i = 0;

	while (str[i] != '\0') {
		if (str[i] < '0' || str[i] > '9') {
			return 0;
		}
		i++;
	}

	return 1;
}

/*
*	Formarea intreger-ului N prin parsarea stringului.
*/
void calculateN(char* str) {

	int x = 0;
	int i = 0;
	while (str[i] != '\0') {
		x *= 10;
		x += str[i] - '0';
		i++;
	}

	N = x;
}

/*
*	Initializarea semafoarelor. Initial vor fi pornite doar barierele si semaforul principal pentru excluderea mutuala.
*/
void initializare_semafoare() {
	sem_init(&barieraMolecula, 0, 1);
	sem_init(&barieraAtomiLiO, 0, 1);
	sem_init(&barieraAtomiNaCl, 0, 1);

	sem_init(&excludereMutuala, 0, 1);

	sem_init(&semaforOxigen, 0, 0);
	sem_init(&semaforLitiu, 0, 0);
	sem_init(&semaforSodiu, 0, 0);
	sem_init(&semaforClor, 0, 0);
	sem_init(&semaforLi2O, 0, 0);
	sem_init(&semaforNaCl, 0, 0);
}

/*
*	Crearea threadurilor pentru atomi. Transmiterea de parametrii nu este necesara.
*/
void creareThreaduriAtomi() {
	pthread_create(&threadLi, NULL, &creareLitiu, NULL);
	pthread_create(&threadO, NULL, &creareOxigen, NULL);
	pthread_create(&threadNa, NULL, &creareSodiu, NULL);
	pthread_create(&threadCl, NULL, &creareClor, NULL);
}

/*
*	Intrarea in threadurile principale pentru fiecarea atom. 
*/
void joinThreaduriAtomi() {
	pthread_join(threadLi, NULL);
	pthread_join(threadO, NULL);
	pthread_join(threadNa, NULL);
	pthread_join(threadCl, NULL);
}

int main(int argc, char const *argv[])
{

	// un singur argument, daca exista mai multi sau mai putini, programul nu trebuie sa ruleze (Partea optionala nu am reusit sa o implementez)
	if (argc != 2) {
		printf("Undefined number of arguments!\n");
		return 0;
	}

	char str[4];
	strcpy(str, argv[1]);
	if (isNumber(str) == 0) {
		printf("Argument must be an positive number!");
		return 0;
	}

	calculateN(str);

	// vectorThreaduri = (pthread_t*)calloc(1, sizeof(pthread_t));
	// vectorThreaduriNaCl = (pthread_t*)calloc(1, sizeof(pthread_t));
	// vectorThreaduriLi2O = (pthread_t*)calloc(1, sizeof(pthread_t));


	int fisier = open("log.dat", O_CREAT | O_RDWR | O_TRUNC, S_IRWXU);
	ftruncate(fisier, 50000000);
	
	// initial fisierul o sa aiba 50MB, ulterior i-am realizat trunchierea in functie de numarul de union-uri create
	vectorUnionStructuri = (union structs_union*) mmap(0, 50000000, PROT_READ | PROT_WRITE, MAP_SHARED, fisier, 0);
	

	initializare_semafoare();
	
	creareThreaduriAtomi();

	joinThreaduriAtomi();

	/*
	*	Acest for are rolul de a trezi eventualele threaduri ramase inactive, la anumite momente de timp.
	*/
	for (int i = 0; i < 1000; i++) {
		sem_post(&barieraMolecula);
		sem_post(&barieraAtomiLiO);
		sem_post(&barieraAtomiNaCl);
		sem_post(&semaforOxigen);
		sem_post(&semaforLitiu);
		sem_post(&semaforSodiu);
		sem_post(&semaforClor);
		sem_post(&semaforLi2O);
		sem_post(&semaforNaCl);
	}

	/*
	*	Parcurgerea tuturor threadurilor si intrarea in ele.
	*/

	for (int i = 0; i < contorThread; i++) {
		pthread_join(vectorThreaduri[i], NULL);
	}

	for (int i = 0; i < contorThreadNaCl; i++) {
		pthread_join(vectorThreaduriNaCl[i], NULL);
	}

	for (int i = 0; i < contorThreadLi2O; i++) {
		pthread_join(vectorThreaduriLi2O[i], NULL);
	}

	/*
	*	calcularea dimensiunii necesare pentru fisier, si trunchierea corespunzatoare a acestuia
	*/
	int diminsiuneFinalFisier = 0;
	diminsiuneFinalFisier += contorUnion * sizeof(union structs_union);

	ftruncate(fisier, diminsiuneFinalFisier);
	close(fisier);

	return 0;
}
