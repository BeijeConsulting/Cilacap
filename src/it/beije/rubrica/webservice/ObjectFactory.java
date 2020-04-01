
package it.beije.rubrica.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.beije.rubrica.webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetNamesResponse_QNAME = new QName("http://server.contacts.jaxws.ws.beije.it/", "getNamesResponse");
    private final static QName _AddContactResponse_QNAME = new QName("http://server.contacts.jaxws.ws.beije.it/", "addContactResponse");
    private final static QName _GetContactByParameter_QNAME = new QName("http://server.contacts.jaxws.ws.beije.it/", "getContactByParameter");
    private final static QName _GetContactByParameterResponse_QNAME = new QName("http://server.contacts.jaxws.ws.beije.it/", "getContactByParameterResponse");
    private final static QName _GetContacts_QNAME = new QName("http://server.contacts.jaxws.ws.beije.it/", "getContacts");
    private final static QName _GetContactsByNameResponse_QNAME = new QName("http://server.contacts.jaxws.ws.beije.it/", "getContactsByNameResponse");
    private final static QName _GetContactsResponse_QNAME = new QName("http://server.contacts.jaxws.ws.beije.it/", "getContactsResponse");
    private final static QName _AddContact_QNAME = new QName("http://server.contacts.jaxws.ws.beije.it/", "addContact");
    private final static QName _GetContactsByName_QNAME = new QName("http://server.contacts.jaxws.ws.beije.it/", "getContactsByName");
    private final static QName _GetNames_QNAME = new QName("http://server.contacts.jaxws.ws.beije.it/", "getNames");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.beije.rubrica.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetContactByParameter }
     * 
     */
    public GetContactByParameter createGetContactByParameter() {
        return new GetContactByParameter();
    }

    /**
     * Create an instance of {@link AddContactResponse }
     * 
     */
    public AddContactResponse createAddContactResponse() {
        return new AddContactResponse();
    }

    /**
     * Create an instance of {@link GetNamesResponse }
     * 
     */
    public GetNamesResponse createGetNamesResponse() {
        return new GetNamesResponse();
    }

    /**
     * Create an instance of {@link AddContact }
     * 
     */
    public AddContact createAddContact() {
        return new AddContact();
    }

    /**
     * Create an instance of {@link GetContactsByName }
     * 
     */
    public GetContactsByName createGetContactsByName() {
        return new GetContactsByName();
    }

    /**
     * Create an instance of {@link GetNames }
     * 
     */
    public GetNames createGetNames() {
        return new GetNames();
    }

    /**
     * Create an instance of {@link GetContactsByNameResponse }
     * 
     */
    public GetContactsByNameResponse createGetContactsByNameResponse() {
        return new GetContactsByNameResponse();
    }

    /**
     * Create an instance of {@link GetContactsResponse }
     * 
     */
    public GetContactsResponse createGetContactsResponse() {
        return new GetContactsResponse();
    }

    /**
     * Create an instance of {@link GetContacts }
     * 
     */
    public GetContacts createGetContacts() {
        return new GetContacts();
    }

    /**
     * Create an instance of {@link GetContactByParameterResponse }
     * 
     */
    public GetContactByParameterResponse createGetContactByParameterResponse() {
        return new GetContactByParameterResponse();
    }

    /**
     * Create an instance of {@link Contact }
     * 
     */
    public Contact createContact() {
        return new Contact();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNamesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.contacts.jaxws.ws.beije.it/", name = "getNamesResponse")
    public JAXBElement<GetNamesResponse> createGetNamesResponse(GetNamesResponse value) {
        return new JAXBElement<GetNamesResponse>(_GetNamesResponse_QNAME, GetNamesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddContactResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.contacts.jaxws.ws.beije.it/", name = "addContactResponse")
    public JAXBElement<AddContactResponse> createAddContactResponse(AddContactResponse value) {
        return new JAXBElement<AddContactResponse>(_AddContactResponse_QNAME, AddContactResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetContactByParameter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.contacts.jaxws.ws.beije.it/", name = "getContactByParameter")
    public JAXBElement<GetContactByParameter> createGetContactByParameter(GetContactByParameter value) {
        return new JAXBElement<GetContactByParameter>(_GetContactByParameter_QNAME, GetContactByParameter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetContactByParameterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.contacts.jaxws.ws.beije.it/", name = "getContactByParameterResponse")
    public JAXBElement<GetContactByParameterResponse> createGetContactByParameterResponse(GetContactByParameterResponse value) {
        return new JAXBElement<GetContactByParameterResponse>(_GetContactByParameterResponse_QNAME, GetContactByParameterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetContacts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.contacts.jaxws.ws.beije.it/", name = "getContacts")
    public JAXBElement<GetContacts> createGetContacts(GetContacts value) {
        return new JAXBElement<GetContacts>(_GetContacts_QNAME, GetContacts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetContactsByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.contacts.jaxws.ws.beije.it/", name = "getContactsByNameResponse")
    public JAXBElement<GetContactsByNameResponse> createGetContactsByNameResponse(GetContactsByNameResponse value) {
        return new JAXBElement<GetContactsByNameResponse>(_GetContactsByNameResponse_QNAME, GetContactsByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetContactsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.contacts.jaxws.ws.beije.it/", name = "getContactsResponse")
    public JAXBElement<GetContactsResponse> createGetContactsResponse(GetContactsResponse value) {
        return new JAXBElement<GetContactsResponse>(_GetContactsResponse_QNAME, GetContactsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddContact }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.contacts.jaxws.ws.beije.it/", name = "addContact")
    public JAXBElement<AddContact> createAddContact(AddContact value) {
        return new JAXBElement<AddContact>(_AddContact_QNAME, AddContact.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetContactsByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.contacts.jaxws.ws.beije.it/", name = "getContactsByName")
    public JAXBElement<GetContactsByName> createGetContactsByName(GetContactsByName value) {
        return new JAXBElement<GetContactsByName>(_GetContactsByName_QNAME, GetContactsByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNames }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.contacts.jaxws.ws.beije.it/", name = "getNames")
    public JAXBElement<GetNames> createGetNames(GetNames value) {
        return new JAXBElement<GetNames>(_GetNames_QNAME, GetNames.class, null, value);
    }

}
