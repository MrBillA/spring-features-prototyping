/*
 * Copyright $today.year Thomson Reuters/ONESOURCE. All rights reserved.
 */

package net.twotwofish.prototype.model;


import java.util.List;


/**
 * User Description.
 *
 * @author Bill Andrews
 */
public interface IPersistenceDao
{
	void addUser(User user);

	void saveUser(User user);

	User getUserById(long id);

	List<Message> getRecentMessages();

	void saveMessage(Message message);

	List<Message> getMessagesByUser(User user);

	User getUserByUsername(String username);

	void deleteMessage(long id);

	Message getMessageById(long id);

	List<Message> findAllMessages();
}
