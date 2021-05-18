#include<iostream>
#include<cstring>
#include<cstdio>
using namespace std;
#define HASHSIZE 101    //size of hash table 
class nlist
{
    public:
    nlist *next;
    char *name;
    char *defn;
};
static nlist *hash_table[HASHSIZE];
unsigned hash_function(char *s)
{
    unsigned hashval;
    for(hashval=0; *s ; s++)
    {
        hashval = *s + 31 * hashval;
    }
    return hashval % HASHSIZE;
}
nlist *lookup(char *s)
{
    nlist *np;
    for(np = hash_table[hash_function(s)]; np!=NULL ; np = np->next )
    {
        if(strcmp(s , np->name) == 0)
            return np;  //found an entry
    }
    return NULL;
}
char *store_key_value(char *s)
{
    char *p;
    p  = (char *)malloc(strlen(s) + 1);
    if(p!=NULL)
    {
        strcpy(p , s);
    }
    return p;
}
nlist  *installKey(char *name , char *defn)
{
    nlist *np;
    unsigned hashval;
    if((np=lookup(name))==NULL)
    {
        nlist key = nlist();
        np = &key;
        np->name = store_key_value(name);
        hashval = hash_function(name);
        hash_table[hashval] = np;
        // np->next = hash_table[hashval];
    }
    else 
    {
        free(np->defn);
    }
    if((np->defn = store_key_value(defn))== NULL)
    return NULL;
    return np;
}
void get_value(char *key)
{
    unsigned index  = hash_function(key);
    cout << hash_table[index]->defn << endl;
}
int main()
{
    nlist *ptr;
    char key[] = "Rahul";
    char value[]  = "Beniwal";
    char key2[] = "luhaR";
    char value2[]  = "beniwal";
    ptr  = installKey(key , value);
    ptr  = installKey(key2 , value2);
    ptr  = installKey("luhaR" , "beniwal");
    ptr =  installKey("kuldeep" , "beniwol");
    get_value("kuldeep");
}
