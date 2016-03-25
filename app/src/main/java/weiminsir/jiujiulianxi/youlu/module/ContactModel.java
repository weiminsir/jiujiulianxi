package weiminsir.jiujiulianxi.youlu.module;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import weiminsir.jiujiulianxi.youlu.activity.MyApplication;
import weiminsir.jiujiulianxi.youlu.entity.Contact;

/**
 * Created by Weimin on 2016/3/14.
 */
public class ContactModel implements IContactModel {
    @Override
    public void loadContact(final Callback callback) {
        new Thread() {
            @Override
            public void run() {
                List<Contact> contactList = loadContacts();
                Log.i("WICK", "ContactModel");
                callback.OnResponse(contactList);
            }
        };
    }
    public List<Contact> loadContacts() {
        List<Contact> contactList = new ArrayList<>();

        ContentResolver resolver = MyApplication.getContext().getContentResolver();
        Uri contactUri = ContactsContract.Contacts.CONTENT_URI;
        String[] colums = {ContactsContract.Contacts._ID,
                ContactsContract.Contacts.PHOTO_ID};
        Cursor cursorOne = resolver.query(contactUri, colums, null, null, null);
        while (cursorOne.moveToNext()) {
            Contact contact = new Contact();
            int id = cursorOne.getInt(0);
            int photoId = cursorOne.getInt(2);
            contact.setId(id);
            contact.setPhotoId(photoId);
            Uri dataUri = ContactsContract.Data.CONTENT_URI;
            String[] projection = {ContactsContract.Data.DATA1,
                    ContactsContract.Data.DATA15,
                    ContactsContract.Data.MIMETYPE};
            Cursor cursorTwo = resolver.query(dataUri, projection, ContactsContract.Data.RAW_CONTACT_ID + "=?",
                    new String[]{"" + id}, null);
            while (cursorTwo.moveToNext()) {
                String data = cursorTwo.getString(0);
                String mt = cursorTwo.getString(2);
                if (mt.equals(ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE)) {
                    contact.setEmail(data);
                } else if (mt.equals(ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)) {
                    contact.setPhone(data);
                } else if (mt.equals("vnd.android.cursor.item/postal-address_v2")) {
                    contact.setAddress(data);
                } else if (mt.equals("vnd.android.cursor.item/name")) {
                    contact.setName(data);
                }
            }
            cursorTwo.close();
            contactList.add(contact);
        }
        cursorOne.close();
        return contactList;
    }
}
