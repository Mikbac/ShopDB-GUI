package sessionAction;


import models.Product;

public class SessionActionProduct extends SessionAction {

    public void create(Product product){

        org.hibernate.Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(product);

        session.getTransaction().commit();
        session.close();

    }


    public void read(int productId)
    {
        org.hibernate.Session session = sessionFactory.openSession();

        Product product = session.get(Product.class,productId);

        if(product != null){
            System.out.println("Id: " + product.getProductId());
            System.out.println("Name: " + product.getName());
            System.out.println("Amount: " + product.getAmount());
            System.out.println("Price: " + product.getPrice());
            System.out.println("Department: " + product.getDepartment());
        }
        else{
            System.out.println("Product could not be found!");
        }


        session.close();
    }

    public Product getProduct(int productId){
        org.hibernate.Session session = sessionFactory.openSession();

        Product product= session.get(Product.class,productId);

        session.close();

        if(product != null){
            return product;
        }
        else{
            return null;
        }

    }

    public void delete(int id){
        Product product = new Product();
        product.setProductId(id);

        org.hibernate.Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.delete(product);

        session.getTransaction().commit();
        session.close();

    }

}
