package com.ppltech.rest;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;
import java.util.Set;

public class MongoDAO {

	private Mongo connection = null;
	private DB db = null;

	private static MongoDAO mongoDAO = null;

	private MongoDAO() throws UnknownHostException {
		// Connect to mongodb
		connection = new MongoClient("localhost", 27017);

		// get database
		db = connection.getDB("test");
	}

	public static MongoDAO getInstance() throws UnknownHostException {
		if (mongoDAO == null) {
			mongoDAO = new MongoDAO();
		}
		return mongoDAO;
	}

	public void createTable(String tableName) throws Exception {
		// If tableName doesn’t exist create it
		Set tableNames = db.getCollectionNames();
		if (!tableNames.contains(tableName)) {
			DBObject dbobject = new BasicDBObject();
			db.createCollection(tableName, dbobject);
		}
	}

	public void saveToDB(String tableName, BasicDBObject dbObject)
			throws Exception {
		DBCollection dbCollection = db.getCollection(tableName);
		dbCollection.insert(dbObject);
	}

	public Set getTableNames() throws Exception {
		return db.getCollectionNames();
	}

	public void showDB(String tableName) throws Exception {
		DBCollection dbCollection = db.getCollection(tableName);
		DBCursor cur = dbCollection.find();
		while (cur.hasNext()) {
			System.out.println(cur.next());
		}
	}

	public DBCursor getAllRows(String tableName) throws Exception {
		DBCollection dbCollection = db.getCollection(tableName);
		DBCursor cur = dbCollection.find();
		return cur;
	}

	public int getRowCount(String tableName) throws Exception {
		DBCollection dbCollection = db.getCollection(tableName);
		DBCursor cur = dbCollection.find();
		return cur.count();
	}

	public DBObject findDocumentById(String tableName, String id) {
		BasicDBObject query = new BasicDBObject();
		query.put("_id", id);
		DBObject dbObj = db.getCollection(tableName).findOne(query);
		return dbObj;
	}

	public DBCursor findByColumn(String tableName, DBObject whereClause)
			throws Exception {
		DBCursor result = null;
		result = db.getCollection(tableName).find(whereClause);
		return result;
	}

	public void createIndex(String tableName, String columnName)
			throws Exception {
		DBCollection dbCollection = db.getCollection(tableName);
		DBObject indexData = new BasicDBObject(columnName, 1);
		dbCollection.createIndex(indexData);
	}

	public void dropTable(String collectionName) {
		db.getCollection(collectionName).drop();
	}

	public void update(String tableName, BasicDBObject selectDocument,
			BasicDBObject newDocument) {
		DBCollection dbCollection = db.getCollection(tableName);
		dbCollection.update(selectDocument, newDocument);
	}
	
	public void update(String tableName, String whereCol, String whereValue,
			BasicDBObject newDocument) {
		DBCollection dbCollection = db.getCollection(tableName);
		BasicDBObject selectDocument = new BasicDBObject().append(whereCol, whereValue);
		dbCollection.update(selectDocument, newDocument);
	}

}
