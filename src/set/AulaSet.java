package set;

import entities.Produto;

import java.util.HashSet;
import java.util.Set;

public class AulaSet {

    public static void main(String[] args) {

        Set<Produto> produtos = new HashSet<Produto>();

        Produto produto1 = new Produto("cama", 500, 10);
        Produto produto2 = new Produto("cama", 500, 5);

//		if(produto1.equals(produto2)) {
//			System.out.println("Produtos iguais!");
//		}else {
//			System.out.println("Produtos diferentes");
//		}
        produtos.add(produto1);
        produtos.add(produto2);

        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }

}

