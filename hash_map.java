class hash_map
{
	public node[] array;
	public double a_max = 2.0;
	public int n = 0;
	public int m = 0;
	public hash_map()
	{
		this.array = new node[3];
	}
	public void add(Comparable key, Comparable value)
	{
		double a = (n*1.0)/m;
		if(a > a_max)
		{
			rehashing(m);
		}
		int i = key.hashCode() % array.length;
		if(array[i] == null)
		{
			array[i] = new node(key, value, null);
			n++;
			m++;
		}
		else
		{
			node tmp = this.array[i];
			while(tmp != null)
			{
				if(tmp.key.compareTo(key) == 0)
				{
					tmp.value = value;
					break;
				}
				tmp = tmp.next;
			}
			if(tmp == null)
			{
				n++;
				array[i] = new node(key, value, array[i]);
			}
		}
	}
	private void rehashing(int k)
	{
		node[] oldArray = array;
		n = 0;
		m = 0;
		array = new node[2*k + 1];
		int i;
		for(i = 0; i < oldArray.length; i++)
		{
			node tmp = oldArray[i];
			while(tmp != null)
			{
				add(tmp.key, tmp.value);
				tmp = tmp.next;
			}
		}
	}
	public Comparable getValue(Comparable key)
	{
		int i = key.hashCode() % array.length;
		if(array[i] == null)
		{
			return null;
		}
		else
		{
			node tmp = array[i];
			while(tmp != null)
			{
				if(tmp.key.compareTo(key) == 0)
				{
					return tmp.value;
				}
				tmp = tmp.next;
			}
		}
		return null;
	}
	public void deleteElement(Comparable key)
	{
		int i = key.hashCode() % array.length;
		if(array[i] == null)
		{
			return;
		}
		else
		{
			node tmp = array[i];
			node nd = null;
			while(tmp != null)
			{
				if(tmp.key.compareTo(key) == 0)
				{
					if(nd == null)
					{
						array[i] = tmp.next;
					}
					else
					{
						nd.next = tmp.next;
					}
					n--;
					if(array[i] == null)
					{
						m--;
					}
					return;
				}
				nd = tmp;
				tmp = tmp.next;
			}
		}
	}
	public void delete()
	{
		array = new node[array.length];
		n = 0;
	}
	public int getSize()
	{
		return n;
	}
	public double get_a()
	{
		return (n*1.0)/m;
	}
	public double get_a_give_a_max(double new_a_max)
	{
		double old = a_max;
		a_max = new_a_max;
		double a = (n*1.0)/m;
		if(a > a_max)
		{
			rehashing(m);
		}
		return old;
	}
	public class node
	{
		Comparable key;
		Comparable value;
		node next;
		public node(Comparable key, Comparable value, node next)
		{
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	
}