package a5;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MorseCodeTreeTest {
	MorseCodeTree mTree;
	
	@Before
	public void setUp() throws Exception {
		mTree=new MorseCodeTree();
	}

	@After
	public void tearDown() throws Exception {
		mTree=null;
	}

	@Test
	public void testAddNode() {
		mTree.insert(".....", "zig");
		assertTrue("zig"==mTree.fetch("....."));
	}

	@Test
	public void testFetch() {
		assertTrue("j"==mTree.fetch(".---"));
	}

	@Test
	public void testBuildTree() {
		assertTrue("e"==mTree.fetch("."));//level 1
		assertTrue("t"==mTree.fetch("-"));

		assertTrue("i"==mTree.fetch(".."));//level 2
		assertTrue("a"==mTree.fetch(".-"));
		assertTrue("n"==mTree.fetch("-."));
		assertTrue("m"==mTree.fetch("--"));

		assertTrue("s"==mTree.fetch("..."));//level 3
		assertTrue("u"==mTree.fetch("..-"));
		assertTrue("r"==mTree.fetch(".-."));
		assertTrue("w"==mTree.fetch(".--"));
		assertTrue("d"==mTree.fetch("-.."));
		assertTrue("k"==mTree.fetch("-.-"));
		assertTrue("g"==mTree.fetch("--."));
		assertTrue("o"==mTree.fetch("---"));

		assertTrue("h"==mTree.fetch("...."));//level 4, left
		assertTrue("v"==mTree.fetch("...-"));
		assertTrue("f"==mTree.fetch("..-."));
		assertTrue("l"==mTree.fetch(".-.."));
		assertTrue("p"==mTree.fetch(".--."));
		assertTrue("j"==mTree.fetch(".---"));
		assertTrue("b"==mTree.fetch("-..."));//level 4, right
		assertTrue("x"==mTree.fetch("-..-"));
		assertTrue("c"==mTree.fetch("-.-."));
		assertTrue("y"==mTree.fetch("-.--"));
		assertTrue("z"==mTree.fetch("--.."));
		assertTrue("q"==mTree.fetch("--.-"));

	}

	@Test
	public void testToArrayList() {
		ArrayList<String> morselist = mTree.toArrayList();
		ArrayList<String> mList = new ArrayList<String>();
		
		mList.add("h");
		mList.add("s");
		mList.add("v");
		mList.add("i");
		mList.add("f");
		mList.add("u");
		mList.add("e");
		mList.add("l");
		mList.add("r");
		mList.add("a");
		mList.add("p");
		mList.add("w");
		mList.add("j");
		mList.add("");//root
		
		mList.add("b");
		mList.add("d");
		mList.add("x");
		mList.add("n");
		mList.add("c");
		mList.add("k");
		mList.add("y");
		mList.add("t");
		mList.add("z");
		mList.add("g");
		mList.add("q");
		mList.add("m");
		mList.add("o");
		assertTrue(mList.equals(morselist));
	}

	@Test
	public void testLNRoutputTraversal() {
		ArrayList<String> morselist = new ArrayList<String>();
		mTree.LNRoutputTraversal(mTree.root, morselist);
		System.out.println(morselist.toString());//pass
	}

}
