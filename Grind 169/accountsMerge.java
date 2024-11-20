class Solution {

    private void dfs(List<String> linkedAccounts, HashMap<String, List<String>> accountGraph,
            HashSet<String> visitedAccounts, String firstEmail) {
        linkedAccounts.add(firstEmail);
        visitedAccounts.add(firstEmail);

        List<String> relatedAccounts = accountGraph.get(firstEmail);
        if (relatedAccounts == null)
            return;
        for (int i = 0; i < relatedAccounts.size(); i++) {
            if (!visitedAccounts.contains(relatedAccounts.get(i)))
                dfs(linkedAccounts, accountGraph,
                        visitedAccounts, relatedAccounts.get(i));
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, List<String>> accountGraph = new HashMap<>();

        for (List<String> account : accounts) {
            int n = account.size();
            String firstEmail = account.get(1);

            for (int i = 2; i < n; i++) {
                String email = account.get(i);
                if (!accountGraph.containsKey(firstEmail)) {
                    accountGraph.put(firstEmail, new ArrayList<>());
                }
                accountGraph.get(firstEmail).add(email);
                if (!accountGraph.containsKey(email)) {
                    accountGraph.put(email, new ArrayList<>());
                }
                accountGraph.get(email).add(firstEmail);
            }
        }
        HashSet<String> visitedAccounts = new HashSet<>();
        List<List<String>> mergedAccounts = new ArrayList<>();

        for (List<String> account : accounts) {
            String accountName = account.get(0);
            String firstEmail = account.get(1);

            if (!visitedAccounts.contains(firstEmail)) {
                List<String> linkedAccounts = new ArrayList<>();
                dfs(linkedAccounts, accountGraph, visitedAccounts, firstEmail);
                if (linkedAccounts.size() > 1)
                    Collections.sort(linkedAccounts);
                linkedAccounts.add(0, accountName);
                mergedAccounts.add(new ArrayList<>(linkedAccounts));
            }
        }
        return mergedAccounts;
    }
}