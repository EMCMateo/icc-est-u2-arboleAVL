
public class AVLTree {
    
    private Node root;



    public AVLTree(){
        this.root = null;
    }

    public void insert(int value){
        System.out.println("Nodo a Insertar: ");

        root = insertRec(root , value);
    }

    private Node insertRec(Node root, int valor){
            if (root == null) {
                Node newNode = new Node(valor);
                newNode.setHeight(1);
                System.out.println("\t Nodo insertado: " + newNode.getValue() + " Balance inicial: " + getBalance(newNode));
                return newNode;
                
            }
            if (valor < root.getValue()) {
                root.setLeft(insertRec(root.getLeft(), valor));
            } else if (valor > root.getValue()) {
                root.setRight(insertRec(root.getRight(), valor));
            } else {
                return root;
            }

            System.out.println("Nodo: " + root.getValue());
            //Actualizar la altura de ancestro node
            int height =1 + Math.max(height(root.getLeft()), height(root.getRight()));
            root.setHeight(height);

            System.out.println(" \t Altura: " + root.getHeight());

            //Obtener balance
            int balance = getBalance(root);
            System.out.println("\t Balance: " + balance);

            //Caso Izquierda Izquierda
            if(balance>1 && (valor < root.getLeft().getValue())){
                System.out.println("Rotacion Izquierda");
            }
            //Casi Derecha Derecha
            if(balance<-1 && (valor > root.getRight().getValue())){
                System.out.println("Rotacion Izquierda");
            }
            //Casi Izqierda Derecha
            if(balance>1 && (valor > root.getLeft().getValue())){
                System.out.println("CAMBIO");
                System.out.println("Rotacion Derecha");

            }

            //Casi Derecha Izquierda
            if(balance<-1 && (valor < root.getRight().getValue())){
                System.out.println("CAMBIO");
                System.out.println("Rotacion Izquierda");
            }


            return root;

        
            
        }

    public int height(Node node){
        if (node == null){
            return 0;
        }
        return node.getHeight();
        
    }

    public int getBalance(Node node){
        if (node == null) {
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }

}