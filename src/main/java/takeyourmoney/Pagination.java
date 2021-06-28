/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takeyourmoney;

/**
 *
 * @author Pascal
 */
public class Pagination {
    
    // PAGINATION : numero de page en cours et offset
    private int pageCourante = 1;
    private int pageCouranteOld = 1;
    
    private final int NB_TOTA_LPAGES;
    private final int PAGINATION;
    
    
    // constructeur ayant besoin de la taille d'une table et de la PAGINATION
    Pagination(int sizeTable, int pagin){
        
        // reste de division entiere : si il est non nul, il faut rajouter 1 à la division entiere   
        if(sizeTable % pagin != 0)
            this.NB_TOTA_LPAGES = (sizeTable / pagin + 1);  // division entiere + 1
        else
            this.NB_TOTA_LPAGES = (sizeTable / pagin);      // division entiere
        
        // pagination
        this.PAGINATION = pagin;
    }
    
    
    // methodes renvoyant un booleen pour la gestion du defilement des ecrans
    // si les methodes renvoient vrai on fait la mise à jour de JTable
    // sinon cela veut dire qu'on est déjà en bout de table et que les requêtes sont inutiles
    
    public boolean pageTOP(){
        this.pageCouranteOld = this.pageCourante;
        this.pageCourante = 1;        
        return (this.pageCouranteOld != this.pageCourante);
    }
          
    public boolean pageUP(){
        this.pageCouranteOld = this.pageCourante;
        int var = this.pageCourante;
        var -= 1;
        this.pageCourante = java.lang.Math.max(1, var);
        return (this.pageCouranteOld != this.pageCourante);
    }
    
    public boolean pageDOWN(){
        this.pageCouranteOld = this.pageCourante;
        int var = this.pageCourante;
        var += 1;
        this.pageCourante = java.lang.Math.min(this.NB_TOTA_LPAGES, var);
        return (this.pageCouranteOld != this.pageCourante);
    }
    
    public boolean pageBOTTOM(){
        this.pageCouranteOld = this.pageCourante;
        this.pageCourante = this.NB_TOTA_LPAGES;        
        return (this.pageCouranteOld != this.pageCourante);
    }
    
    // calcule l'offset de pagination pour SELECT LIMIT OFFSET
    public int getOffset(){
        return (this.pageCourante - 1) * this.PAGINATION;        
    }
    
    // getters
    public int getPageCourante()    { return this.pageCourante; }
    public int getPageCouranteOld() { return this.pageCouranteOld; }
    public int getnbTotalPages()    { return this.NB_TOTA_LPAGES; }
    public int getPagination()      { return this.PAGINATION; }
}

