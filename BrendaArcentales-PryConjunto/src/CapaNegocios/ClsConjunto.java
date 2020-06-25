/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocios;

/**
 *
 * @author Programacion Objetos
 */
public class ClsConjunto {
    private int _card;
    private String [] _elem;
    
    public ClsConjunto()
    {
        _card=0;
    }
    public ClsConjunto(int m,String [] el){
    _card=m;
    _elem=el;
    }
    public ClsConjunto(int m){
    _card=m;
    _elem=new String[m];
    }
   public ClsConjunto(ClsConjunto m){
       _card=m._card;
       _elem=m._elem;
   }

    public int getCard() {
        return _card;
    }

    public void setCard(int _card) {
        this._card = _card;
    }

    public String[] getElem() {
        return _elem;
    }

    public void setElem(String[] _elem) {
        this._elem = _elem;
    }
        
    public String elem(int k)
    {
        return _elem[k];
        
    }
    public String elem(int k, String dato)
    {
        return _elem[k]=dato;
        
    }
    public boolean existe(String val)
    {
        boolean existe=false;   
        for (int i=1;i<_card;i++)
        {
            if(_elem[i].equals(val))
            {
                return existe=true;
            }
        }
         return existe;   
    }
    public ClsConjunto union(ClsConjunto m){
        ClsConjunto union = new ClsConjunto(_card + m._card);
        int k=_card;
        System.arraycopy(_elem, 0, union._elem, 0, _card);
        for(int i=0; i<m._card; i++)
        {
            if(!this.existe(m._elem[i])){
                union._elem[k]=m._elem[i];
                k=k+1;
            }
        }
        union._card=k;
        return union;
    }
    public ClsConjunto interseccion(ClsConjunto m) 
    { 
        ClsConjunto interseccion= new ClsConjunto(_card+m._card);
        int k=0;
        for(int i=0;i<m._card;i++)
        {
            if(this.existe(m._elem[i]))
            {
                interseccion._elem[k]=m._elem[i];
                k=k+1;
            }
        }
        interseccion._card=k;
        return interseccion;     
    }
    public ClsConjunto diferencia(ClsConjunto m){
        int k = 0;
        ClsConjunto diferencia = new ClsConjunto(_card);
        for(int i = 0;  i < m._card;i++){
            if (!this.existe(m._elem[i])){
                diferencia._elem[k] = m._elem[i];
                k = k + 1;
            }
        }
        diferencia._card = k;
        return diferencia;
    }
    
    public ClsConjunto difesime(ClsConjunto m){
        ClsConjunto dife = new ClsConjunto(_card + m._card);
        int k = 0;
        for(int i = 0;  i < m._card;i++){
            if (!this.existe(m._elem[i])){
                dife._elem[k] = m._elem[i];
                k = k + 1;
            }
        }
        for(int i = 0;  i < _card;i++){
            boolean existe1 = false;
            for(int j = 0; j < m._card; j++) {
                if (m._elem[j].equals(_elem[i])){
                    existe1 = true;
                    break;
                }
            }
            if (!existe1){
                dife._elem[k] = _elem[i];
                k = k + 1;
            }
        }
        dife._card = k;
        return dife;
    }
    public ClsConjunto productcart(ClsConjunto m)
    {
        ClsConjunto produc = new ClsConjunto(_card + m._card);
        int k=m._card*produc._card;
        for(int i = 0;  i < m._card;i++){
            for(int j=0; j<produc._card;j++){
                produc._elem[k] ="(" +  _elem[i] + ","+m._elem[j]+ ")";
                k = k + 1;
            }
        }
        k=m._card;
        for(int i = 0;  i < m._card;i++)
        {
            produc._elem[k] = m._elem[i];
        }
        produc._card = k;
        return produc;
    }
    public String toString ()
    {
        String salida="{ ";
        for(int i=0;i<_card-1;i++)
            salida+=_elem[i]+ ",";
        salida+=_elem[_card-1]+ "}";
        return salida;
    }
}
