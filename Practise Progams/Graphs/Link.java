public class Link
{

	public String bookname;
	public int millionssold;

	public Link next;

	public static void main(String[] args)
	{
		LinkedList theLinkedList = new LinkedList();
		
		theLinkedList.insertFirstLink("The Lost Symbol", 300);
		theLinkedList.insertFirstLink("Harry Potter the Sorceror's Stone", 800);
		theLinkedList.insertFirstLink("LOTR : The two towers", 1000);
		
		theLinkedList.display();
		System.out.println("__________________________________");
		
		theLinkedList.removeLink("LOTR : The two towers");
		theLinkedList.display();
	}

	public Link(String bookname, int millionssold)
	{
		this.bookname = bookname;
		this.millionssold = millionssold;
	}

	public void display()
	{
		System.out.println(bookname + " : " + millionssold + ",00,000");
	}

	public String toString()
	{
		return bookname;
	}

}


class LinkedList
{
	public Link firstLink;
	
	LinkedList()
	{
		firstLink = null;
	}
	
	public boolean isEmpty()
	{
		return firstLink == null;
	}
	
	public void insertFirstLink(String bookname, int millionsold)
	{
		Link newLink = new Link(bookname, millionsold);
		newLink.next = firstLink;
		firstLink = newLink;
	}
	
	public Link removeFirst()
	{
		Link linkReference = firstLink;
		if(!isEmpty())
		{
			firstLink = firstLink.next;
		}
		else
		{
			System.out.println("The Link List is empty");
		}
		
		return linkReference;
	}
	
	public void display()
	{
		Link theLink = firstLink;
		
		while(theLink != null)
		{
			theLink.display();
			System.out.println("The next link is : " + theLink.next);
			theLink = theLink.next;
			System.out.println();
		}
		
	}
	
	public Link find(String bookname)
	{
		Link theLink = firstLink;
		if(!isEmpty())
		{
			while(theLink.bookname != bookname)
			{
				if(theLink.next == null)
				{
					return null;
				}
				else
				{
					theLink = theLink.next;
				}
			}
		}
		else
		{
			System.out.println("The list is empty");
		}
		return theLink;
	}
	
	public Link removeLink(String bookname)
	{
		Link currentLink = firstLink;
		Link previousLink = firstLink;
		
		while( currentLink.bookname != bookname)
		{
			if(currentLink.next == null)
			{
				return null;
			}
			else
			{
				previousLink = currentLink;
				currentLink = currentLink.next;
			}
			
		}
		
		if(currentLink == firstLink)
		{
			firstLink = firstLink.next;
		}
		else
		{
			previousLink.next = currentLink.next;
		}
		return currentLink;
	}
}
	
	
					
			
	
	
	