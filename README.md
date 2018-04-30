# SpringGenesys

Ohjelmistoprojekti I

## Git Branching

by Topi Kettunen <topi@topikettunen.com>

Make new branch with:

```
$ git checkout -b <branch-name> <start-point>
```

E.g.

```
$ git checkout -b new-feature master
```

Change to your new branch by (should be done automatically):

```
$ git checkout new-feature
```

In your new branch you can do all the regular Git tasks, e.g. `git add`, `git commit` and `git push`.

When your new feature is done, you can request Pull Request on GitHub so that feature would be added to `master` branch.

If you happen to change computers during your coding. You can clone the repository with:

```
$ git clone -b <your-branch> https://github.com/rottabonus/SpringGenesys.git
```
