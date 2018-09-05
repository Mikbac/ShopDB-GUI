package sessionAction;


import models.Supplier;

public class SessionActionSupplier extends SessionAction {

    public void create(Supplier supplier) {

        org.hibernate.Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(supplier);

        session.getTransaction().commit();
        session.close();

    }


    public void read(int supplierId) {
        org.hibernate.Session session = sessionFactory.openSession();

        Supplier supplier = session.get(Supplier.class, supplierId);

        if (supplier != null) {
            System.out.println("Id: " + supplier.getSupplierId());
            System.out.println("Name: " + supplier.getName());
            System.out.println("Address: " + supplier.getAddress());
            System.out.println("Phone: " + supplier.getPhone());
            System.out.println("Nip: " + supplier.getNip());

        } else {
            System.out.println("Supplier could not be found!");
        }


        session.close();
    }

    public Supplier getSupplier(int supplierId) {
        org.hibernate.Session session = sessionFactory.openSession();

        Supplier supplier = session.get(Supplier.class, supplierId);

        session.close();

        if (supplier != null) {
            return supplier;
        } else {
            return null;
        }

    }

    public void delete(int id) {
        Supplier supplier = new Supplier();
        supplier.setSupplierId(id);

        org.hibernate.Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.delete(supplier);

        session.getTransaction().commit();
        session.close();

    }

}
