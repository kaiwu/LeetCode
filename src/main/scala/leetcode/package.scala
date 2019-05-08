/** =Leetcode Solutions in Scala=
  *
  * This project was created with a few purposes
  *
  * First it is to help boost language [[http://scala-lang.org Scala]] and
  * its functional approach to solve problems, Scala is expressive, succinct
  * meanwhile far too much underrated. Second let's just admit one ''cannot''
  * judge the engineering calibers of another in one hour technical interview,
  * I personally have had and failed a few and I want to do something to alleviate
  * this madness of the industry. Use ''Search'' above and type in some method names
  * to get the point ...
  *
  * The listed solutions are by no means complete or optimal, if you would
  * agree the causes, and feel like to contribute solutions, fixes or scaladocs
  * to better illustrate everything, all [[https://github.com/kaiwu/leetcode PRs]]
  * are welcome !
  *
  */
package object leetcode {
  class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x
  }

  object ListNode {

    /**
      *
      */
    def apply(ls: List[Int]): ListNode = ls match {
      case Nil => null
      case h :: t => {
        val n = new ListNode(h)
        n.next = apply(t)
        n
      }
    }

    /**
      *
      */
    @annotation.tailrec
    def isEqual(n1: ListNode, n2: ListNode): Boolean = (n1, n2) match {
      case (null, null) => true
      case (ln1, ln2) if ln1 != null && ln2 != null =>
        if (ln1.x == ln2.x) isEqual(ln1.next, ln2.next)
        else false
      case _ => false
    }

    /**
      *
      */
    @annotation.tailrec
    def show(n: ListNode, s: String = ""): String =
      if (n == null) s + "null"
      else show(n.next, s + s"${n.x} -> ")

    @annotation.tailrec
    def reverse(ls: ListNode, p: ListNode = null): ListNode =
      if (ls != null) {
        val n = ls.next
        ls.next = p
        reverse(n, ls)
      } else p
  }

  implicit class ListNodeSyntax(n: ListNode) {
    import ListNode._
    def `===`(ln: ListNode): Boolean = isEqual(n, ln)
    override def toString(): String = show(n)
    def reverse : ListNode = ListNode.reverse(n)
  }

}
