/* *
 * Use dynamic array for NewsFeed
 * by using increaseSize() method
 * */

public class NewsFeed {

    private Post[] messages;
    private int capacityIncrement;
    private int size;

    public NewsFeed(int capacity, int capacityIncrement) {
	// preconditions: capacity > 0, capactityIncrement > 0
	messages = new Post[capacity];
	this.capacityIncrement = capacityIncrement;
	size = 0;
    }

    public void add(Post message) {
	if (size == messages.length) {
	    increaseSize();
	}
	messages[size++] = message;
    }

    private void increaseSize() {
	Post[] current = messages;
	messages = new Post[current.length + capacityIncrement];
	System.arraycopy(current, 0, messages, 0, current.length);

    }

    public Post get(int index) {
	// precondition: 0 <= index < size
	return messages[index];
    }

    public int size() {
	return size;
    }

	public void sort(){
			int i, j, argMin;
			Post tmp;
			for (i = 0; i < size - 1; i++) {
				argMin = i;
				for (j = i + 1; j < size(); j++) {
					if (messages[j].compareTo(messages[argMin]) < 0) {
						argMin = j;
					}
				}

			tmp = messages[argMin];
			messages[argMin] = messages[i];
			messages[i] = tmp;
		}

	}

	public NewsFeed getPhotoPost(){
		NewsFeed photoFeed = new NewsFeed(size, size);

		for(int i=0; i < size; i++){
			if (messages[i] instanceof PhotoPost){
			photoFeed.add(messages[i]);
			}
		}
		return photoFeed;
	}

	public NewsFeed plus(NewsFeed other){

		NewsFeed newFeed = new NewsFeed(size + other.size, size + other.size);

		//Adds all of posts in first NewsFeed to new NewsFeed
		for (int i = 0; i < size(); i++){
			newFeed.add(messages[i]);
		}

		//Adds all of posts in second NewsFeed to new NewsFeed
		for (int j = 0; j < other.size(); j++){
			newFeed.add(other.messages[j]);
		}

		newFeed.sort();
		return newFeed;
	}

}
